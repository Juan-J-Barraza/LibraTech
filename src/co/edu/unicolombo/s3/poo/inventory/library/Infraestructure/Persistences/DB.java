
package co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.*;
import java.util.*;

/**
 *
 * @author Juan
 */
public class DB {
    private final List<Book> listBooks;
    private final List<Category> categories;
    private final List<Publisher> listPublishers;
    private final List<Loan> listLoans;
    private final List<Client> listClients;
    private final List<Reservation> listReservations;
    private static DB instance;

    public DB() {
        this.listBooks = new ArrayList<>();
        this.categories = new ArrayList<>();
        this.listPublishers = new ArrayList<>();
        this.listLoans = new ArrayList<>();
        this.listClients = new ArrayList<>();
        this.listReservations = new ArrayList<>();
        createDefaultClients();
        createDefaultCategories();
        createDefaultPublisher();
        createDefaultBooks();
    }

    public static DB getInstance() {
        if (instance == null) {
            instance = new DB();
        }
        return instance;
    }

    public List<Book> getListBooks() {
        return listBooks;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<Publisher> getListPublishers() {
        return listPublishers;
    }

    public List<Loan> getListLoans() {
        return listLoans;
    }

    public List<Client> getListClients() {
        return listClients;
    }

    public List<Reservation> getListReservations() {
        return listReservations;
    }

    private void createDefaultCategories() {
        categories.add(new Category("Fiction"));
        categories.add(new Category("Science"));
        categories.add(new Category("History"));
        categories.add(new Category("Not fiction"));
    }

    private void createDefaultPublisher() {
        listPublishers.add(new Publisher("ED.J.Creations"));
    }

    public void createDefaultBooks() {
        Book book = new Book(
                "ABC123",
                "Harry Potter",
                new Date(),
                2,
                new Publisher("J.K.Rolling"),
                new Category("Fiction"));
        listBooks.add(book);
        categories.add(book.getCategory());
    }

    public void createDefaultClients() {
        listClients.add(new Client("Juan Barraza", "Pozon", "3001234567"));
    }

    public int getIndexBookByISB(String ISB) {
        for (int i = 0; i < listBooks.size(); i++) {
            if (listBooks.get(i).getISB()
                    .equalsIgnoreCase(ISB)) {
                return i;
            }
        }
        return -1;
    }

    public int getIndexBookByTitle(String title) {
        for (int i = 0; i < listBooks.size(); i++) {
            if (listBooks.get(i).getTitle()
                    .equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1;
    }

    public int getIndexClientById(int id) {
        for (int i = 0; i < listClients.size(); i++) {
            if (listClients.get(i).getID() == id) {
                return i;
            }
        }
        return -1;
    }

    public int getIndexReservationById(int id) {
        for (int i = 0; i < listReservations.size(); i++) {
            if (listReservations.get(i).getID() == id) {
                return i;
            }
        }
        return -1;
    }

    public int getIndexLoanById(int id) {
        for (int i = 0; i < listLoans.size(); i++) {
            if (listLoans.get(i).getID() == id) {
                return i;
            }
        }
        return -1;
    }
}
