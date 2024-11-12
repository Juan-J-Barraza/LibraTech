package co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Repositories;

// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Book;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Config.HibernateUtil;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.BookEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.IBookRepository;
import org.hibernate.Session;
// import org.hibernate.query.Query;
import org.hibernate.SessionFactory;

import java.util.List;

public class BookRepository implements IBookRepository {

    private final SessionFactory sessionFactory;

    public BookRepository() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void addBook(BookEntity book) throws Exception {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(book);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null && session.getTransaction().getStatus().canRollback()) {
                session.getTransaction().rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public List<BookEntity> getListBooks() throws Exception {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM BookEntity", BookEntity.class).getResultList();

        }
    }

    @Override
    public BookEntity getBookByISB(String ISB) throws Exception {
        Session session = sessionFactory.openSession();
        try {
            BookEntity entity = session.createQuery("FROM BookEntity WHERE isbn = :isb", BookEntity.class)
                    .setParameter("isb", ISB)
                    .uniqueResult();

            if (entity == null) {
                throw new Exception("Book not found.");
            }

            return entity;
        } finally {
            session.close();
        }
    }

    @Override
    public void updateBook(BookEntity book) throws Exception {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            BookEntity entity = session.get(BookEntity.class, book.getId());
            if (entity == null) {
                throw new Exception("Book not found.");
            }
            entity.setTitle(book.getTitle());
            entity.setPublication(book.getPublication());
            entity.setStock(book.getStock());
            entity.setPublisherEntity(book.getPublisherEntity());
            entity.setCategoryEntity(book.getCategoryEntity());
            session.update(entity);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteBook(BookEntity book) throws Exception {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            BookEntity entity = session.get(BookEntity.class, book.getId());
            if (entity == null) {
                throw new Exception("Book not found.");
            }
            session.delete(entity);
            session.getTransaction().commit();
        } finally {
            if (session.getTransaction() != null && session.getTransaction().getStatus().canRollback()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
    }

    @Override
    public boolean bookIsAvailable(BookEntity book) {
        Session session = sessionFactory.openSession();
        try {
            BookEntity entity = session.createQuery("FROM BookEntity WHERE id = :id", BookEntity.class)
            .setParameter("id", book.getId())
            .uniqueResult();
            
            if (book == null || book.getId() == 0) {
                return false;
            }
            return entity != null && entity.isAvailable() && entity.getStock() > 0;
        } finally {
            session.close();
        }
    }

    @Override
    public void addBookToStock(int amount, String title) throws Exception {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            BookEntity entity = session.createQuery("FROM BookEntity WHERE LOWER(title) = :title", BookEntity.class)
                    .setParameter("title", title.toLowerCase())
                    .uniqueResult();
            if (entity == null) {
                throw new Exception("Book not found.");
            }
            entity.setStock(entity.getStock() + amount);
            session.update(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null && session.getTransaction().getStatus().canRollback()) {
                session.getTransaction().rollback();
            }
            throw e;

        } finally {
            session.close();
        }
    }

    @Override
    public void removeBookFromStock(int amount, String title) throws Exception {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            BookEntity entity = session.createQuery("FROM BookEntity WHERE title = :title", BookEntity.class)
                    .setParameter("title", title)
                    .uniqueResult();

            if (entity == null) {
                throw new Exception("Book not found.");
            }

            if (entity.getStock() < amount) {
                throw new Exception("Not enough stock for the loan.");
            }

            entity.setStock(entity.getStock() - amount);
            session.update(entity);
            session.getTransaction().commit();

            if (entity.getStock() == 0) {
                boolean updated = bookIsFalseAvailable(entity.getISB());
                if (!updated) {
                    throw new Exception("Failed to update book availability.");
                }
            }

        } catch (Exception e) {
            if (session.getTransaction() != null && session.getTransaction().getStatus().canRollback()) {
                session.getTransaction().rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean bookIsFalseAvailable(String ISB) throws Exception {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            BookEntity book = session.createQuery("FROM BookEntity WHERE isbn = :isb", BookEntity.class)
                    .setParameter("isb", ISB)
                    .uniqueResult();
            if (book != null && book.getStock() == 0) {
                book.setAvailable(false);
                session.update(book);
                session.getTransaction().commit();
                return true;
            } else {
                if (book == null) {
                    throw new Exception("Book not found.");
                } else {
                    session.getTransaction().commit();
                    return false;

                }
            }
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public void bookIsTrueAvailable(String ISB) throws Exception {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            BookEntity book = session.createQuery("FROM BookEntity WHERE isbn = :isb", BookEntity.class)
                    .setParameter("isb", ISB)
                    .uniqueResult();
            if (book != null && book.getStock() > 0) {
                book.setAvailable(true);
                session.update(book);
                session.getTransaction().commit();
            } else {
                if (book == null) {
                    throw new Exception("Book not found.");
                } else {
                    throw new Exception("Stock is 0 or the book does not exist");
                }
            }
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public BookEntity getBookByTitle(String title) throws Exception {
        Session session = sessionFactory.openSession();
        try {
            BookEntity entity = session.createQuery("FROM BookEntity WHERE LOWER(title) = :title", BookEntity.class)
                    .setParameter("title", title.toLowerCase())
                    .uniqueResult();

            if (entity == null) {
                throw new Exception("Book not found");
            }
            return entity;
        } finally {
            session.close();
        }
    }
}
