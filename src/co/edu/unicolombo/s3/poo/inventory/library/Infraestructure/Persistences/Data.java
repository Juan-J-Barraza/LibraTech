
package co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences;

import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Config.HibernateUtil;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.BookEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.CategoryEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.ClientEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.PublisherEntity;

import java.util.List;
import java.sql.Date;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Juan
 */
public class Data {
    // private final List<Book> listBooks;
    // private final List<CategoryEntity> categories;
    // private final List<PublisherEntity> listPublishers;
    // private final List<LoanEntity> listLoans;
    // private final List<ClientEntity> listClients;
    // private final List<ReservationEntity> listReservations;
    private static Data instance;
    private final SessionFactory sessionFactory;

    public Data() {
        // this.listBooks = new ArrayList<>();
        // this.categories = new ArrayList<>();
        // this.listPublishers = new ArrayList<>();
        // this.listLoans = new ArrayList<>();
        // this.listClients = new ArrayList<>();
        // this.listReservations = new ArrayList<>();
        this.sessionFactory = HibernateUtil.getSessionFactory();
        createDefaultCategories();
        createDefaultPublisher();
        createDefaultClients();
        createDefaultBooks();

    }

    public static Data getInstance() {
        if (instance == null) {
            instance = new Data();
        }
        return instance;
    }

    // public List<Book> getListBooks() {
    // return listBooks;
    // }

    // public List<Category> getCategories() {
    // return categories;
    // }

    // public List<Publisher> getListPublishers() {
    // return listPublishers;
    // }

    // public List<Loan> getListLoans() {
    // return listLoans;
    // }

    // public List<Client> getListClients() {
    // return listClients;
    // }

    // public List<Reservation> getListReservations() {
    // return listReservations;
    // }

    public void createDefaultCategories() {
        Session session = sessionFactory.openSession();
        List<CategoryEntity> categories = new ArrayList<>();
        categories.add(new CategoryEntity("Fiction"));
        categories.add(new CategoryEntity("Science"));
        categories.add(new CategoryEntity("History"));
        categories.add(new CategoryEntity("Not fiction"));
        for (CategoryEntity categoryEntity : categories) {
            CategoryEntity existingCategory = session
                    .createQuery("FROM CategoryEntity WHERE name = :name", CategoryEntity.class)
                    .setParameter("name", categoryEntity.getName())
                    .uniqueResult();

            if (existingCategory == null) {
                try {
                    session.beginTransaction();
                    session.save(categoryEntity);
                    session.getTransaction().commit();
                } catch (Exception e) {
                    if (session.getTransaction() != null && session.getTransaction().getStatus().canRollback()) {
                        session.getTransaction().rollback();
                    }
                    throw e;
                }
            } 
            break;
        }
    }

    public void createDefaultPublisher() {
        Session session = sessionFactory.openSession();
        List<PublisherEntity> publisherEntities = new ArrayList<>();
        publisherEntities.add(new PublisherEntity("ED.J.Creations"));
        for (PublisherEntity publisher : publisherEntities) {
            PublisherEntity exiPublisherEntity = session
                    .createQuery("FROM PublisherEntity WHERE name = :name", PublisherEntity.class)
                    .setParameter("name", publisher.getName())
                    .uniqueResult();
            if (exiPublisherEntity == null) {

                try {
                    session.beginTransaction();
                    session.save(publisher);
                    session.getTransaction().commit();
                } catch (Exception e) {
                    if (session.getTransaction() != null && session.getTransaction().getStatus().canRollback()) {
                        session.getTransaction().rollback();
                    }
                    throw e;
                }
            }
            break;
        }
    }

    public void createDefaultClients() {
        Session session = sessionFactory.openSession();
        List<ClientEntity> clients = new ArrayList<>();
        clients.add(new ClientEntity("Juan Barraza", "Pozon", "3001234567"));
        clients.add(new ClientEntity("Deiver jose", "San jose", "309827732"));

        for (ClientEntity client : clients) {
            ClientEntity extClientEntity = session
                    .createQuery("FROM ClientEntity WHERE name = :name", ClientEntity.class)
                    .setParameter("name", client.getName())
                    .uniqueResult();

            if (extClientEntity == null) {
                try {
                    session.beginTransaction();
                    session.save(client);
                    session.getTransaction().commit();
                } catch (Exception e) {
                    if (session.getTransaction() != null && session.getTransaction().getStatus().canRollback()) {
                        session.getTransaction().rollback();
                    }
                    throw e;
                }
            }
        }
    }

    public void createDefaultBooks() {
        Session session = sessionFactory.openSession();
        long millis = System.currentTimeMillis();
        Date dateNow = new Date(millis);
        var publisher = session.createQuery("FROM PublisherEntity", PublisherEntity.class)
                .setMaxResults(1)
                .uniqueResult();
        var category = session.createQuery("FROM CategoryEntity", CategoryEntity.class)
                .setMaxResults(1)
                .uniqueResult();
        BookEntity existingBook = session.createQuery("FROM BookEntity WHERE isbn = :isbn", BookEntity.class)
                .setParameter("isbn", "ABC123")
                .uniqueResult();

        if (existingBook == null) {
            List<BookEntity> books = new ArrayList<>();
            books.add(new BookEntity("ABC123", "Harry Potter", dateNow, 4, publisher, category));

            for (BookEntity book : books) {
                try {
                    session.beginTransaction();
                    session.save(book);
                    session.getTransaction().commit();
                } catch (Exception e) {
                    if (session.getTransaction() != null && session.getTransaction().getStatus().canRollback()) {
                        session.getTransaction().rollback();
                    }
                    throw e;
                }
            }
        } 
    }

    // private void createDefaultCategoriesList() {
    // categories.add(new CategoryEntity("Fiction"));
    // categories.add(new CategoryEntity("Science"));
    // categories.add(new CategoryEntity("History"));
    // categories.add(new CategoryEntity("Not fiction"));

    // }

    // private void createDefaultPublisher() {
    // listPublishers.add(new PublisherEntity("ED.J.Creations"));
    // }

    // public void createDefaultBooks() {
    // Book book = new BookEntity(
    // "ABC123",
    // "Harry Potter",
    // new Date(),
    // 2,
    // new PublisherEntity("J.K.Rolling"),
    // new CategoryEntity("Fiction"));
    // listBooks.add(book);
    // }

    // public void createDefaultClients() {
    // listClients.add(new Client("Juan Barraza", "Pozon", "3001234567"));
    // }

    // public int getIndexBookByISB(String ISB) {
    // for (int i = 0; i < listBooks.size(); i++) {
    // if (listBooks.get(i).getISB()
    // .equalsIgnoreCase(ISB)) {
    // return i;
    // }
    // }
    // return -1;
    // }

    // public int getIndexBookByTitle(String title) {
    // for (int i = 0; i < listBooks.size(); i++) {
    // if (listBooks.get(i).getTitle()
    // .equalsIgnoreCase(title)) {
    // return i;
    // }
    // }
    // return -1;
    // }

    // public int getIndexClientById(int id) {
    // for (int i = 0; i < listClients.size(); i++) {
    // if (listClients.get(i).getID() == id) {
    // return i;
    // }
    // }
    // return -1;
    // }

    // public int getIndexReservationById(int id) {
    // for (int i = 0; i < listReservations.size(); i++) {
    // if (listReservations.get(i).getID() == id) {
    // return i;
    // }
    // }
    // return -1;
    // }

    // public int getIndexLoanById(int id) {
    // for (int i = 0; i < listLoans.size(); i++) {
    // if (listLoans.get(i).getID() == id) {
    // return i;
    // }
    // }
    // return -1;
    // }
}
