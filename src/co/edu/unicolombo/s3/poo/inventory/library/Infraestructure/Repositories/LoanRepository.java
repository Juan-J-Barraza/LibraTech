package co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Repositories;

// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Book;
// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Client;
// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Loan;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Config.HibernateUtil;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.BookEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.BookLoanEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.ClientEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.LoanEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.ILoanRepository;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.*;
// import java.util.stream.Collectors;

public class LoanRepository implements ILoanRepository {
    private final SessionFactory sessionFactory;
    private final BookRepository bookRepository;

    public LoanRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void addloanBook(LoanEntity loan) throws Exception {
        if (loan == null) {
            throw new Exception("You cannot borrow a null loan.");
        }

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            System.out.println("list of books in loan: " + loan.getBooks().size());
            System.out.println("book loan: " + loan.getBooks().iterator().next().getTitle());
            // Reduce stock based on the books in the loan
            for (BookEntity book : loan.getBooks()) {
                System.out.println("iniciatialization:" + book.getTitle());
                System.out.println("loans book: " + book.getLoans().iterator().next().getId());
                System.out.println("get in on remove to stock");
                Hibernate.initialize(book.getLoans());
                BookLoanEntity bookLoan = new BookLoanEntity();
                bookLoan.setBook(book);
                bookLoan.setLoan(loan);
                System.out.println("the book is: " + book.getTitle());
                System.out.println("exit of remove to stock");
            }

            session.save(loan);
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
    public List<LoanEntity> getLoans() throws Exception {
        Session session = sessionFactory.openSession();
        try {
            List<LoanEntity> loans = session.createQuery("FROM LoanEntity", LoanEntity.class).list();
            if (loans == null || loans.isEmpty()) {
                throw new Exception("No loans found.");
            }
            System.out.println("the books are corrects");
            return loans;
        } finally {
            session.close();
        }
    }

    @Override
    public ClientEntity getClientFromLoan(int idClient) throws Exception {
        if (idClient == 0) {
            throw new Exception("ID of client is invalid");
        }

        Session session = sessionFactory.openSession();
        try {
            ClientEntity client = session
                    .createQuery("FROM LoanEntity l WHERE l.client.id = :idClient", ClientEntity.class)
                    .setParameter("idClient", idClient)
                    .uniqueResult();

            if (client == null) {
                throw new Exception("Client not found for the given loan ID.");
            }

            return client;
        } finally {
            session.close();
        }
    }

    @Override
    public void returnBook(LoanEntity loan) throws Exception {
        if (loan == null) {
            throw new Exception("Loan is null");
        }
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            for (BookEntity book : loan.getBooks()) {
                var title = book.getTitle();
                var quantity = loan.getQuantity();
                bookRepository.addBookToStock(quantity, title);
            }
            loan.getBooks().clear();
            session.update(loan);
            
            session.delete(loan);
            session.getTransaction().commit();
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
    public List<ClientEntity> getListClientsWithLoan() throws Exception {
        Session session = sessionFactory.openSession();
        try {
            // Retrieve all loans and their associated clients from the database
            List<LoanEntity> loans = session.createQuery("FROM LoanEntity", LoanEntity.class).list();
            if (loans == null || loans.isEmpty()) {
                throw new Exception("No loans found.");
            }

            List<ClientEntity> clients = new ArrayList<>();
            for (LoanEntity loan : loans) {
                clients.add(loan.getClient());
            }

            return clients;
        } finally {
            session.close();
        }
    }

    @Override
    public LoanEntity findLoanByBook(BookEntity book) throws Exception {
        if (book == null) {
            throw new Exception("Book cannot be null");
        }
        Session session = sessionFactory.openSession();
        try {
            List<LoanEntity> loans = session
                    .createQuery("FROM LoanEntity l JOIN FETCH l.books b WHERE b.id = :bookId", LoanEntity.class)
                    .setParameter("bookId", book.getId())
                    .list();

            if (loans.isEmpty()) {
                throw new Exception("No loan found for the selected book.");
            }
            return loans.get(0);
        } finally {
            session.close();
        }
    }

    @Override
    public List<LoanEntity> getBooksWithLoansByCategory(String name) throws Exception {
        if (name == null) {
            throw new Exception("The category is null.");
        }
        Session session = sessionFactory.openSession();
        try {
            // Query to find loans containing books from the specified category
            List<LoanEntity> loans = session
                    .createQuery("SELECT l FROM LoanEntity l JOIN l.books b WHERE b.category.name = :categoryName",
                            LoanEntity.class)
                    .setParameter("categoryName", name)
                    .list();

            return loans;
        } finally {
            session.close();
        }
    }

}
