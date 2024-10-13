package co.edu.unicolombo.s3.poo.inventory.library.Domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan
 */
public class Db {

    private final List<Book> listBooks;
    private final List<Category> categories;
    private final List<Author> listAuthors;
    private final List<Publisher> listPublishers;
    private final List<Loan> listLoans;
    private final List<Client> listClients;
    private final List<Reservation> listReservations;
    //private final User user;
    private static Db instance;

    public Db() {
        this.listBooks = new ArrayList<>();
        this.categories = new ArrayList<>();
        this.listAuthors = new ArrayList<>();
        this.listPublishers = new ArrayList<>();
        this.listLoans = new ArrayList<>();
        this.listClients = new ArrayList<>();
        this.listReservations = new ArrayList<>();
        createDefaultCategories();
        createDefaultAthores();
        createDefaultPublisher();
        // this.user = new User("Jose", "300422532", null );
    }

    public static Db getInstance() {
        if (instance == null) {
            instance = new Db();
        }
        return instance;
    }

    private void createDefaultCategories() {
        categories.add(new Category("Fiction"));
        categories.add(new Category("Science"));
        categories.add(new Category("History"));
        categories.add(new Category("Not fiction"));
    }

    private void createDefaultAthores() {
        listAuthors.add(new Author("Jose", "Ignacio"));
    }

    private void createDefaultPublisher() {
        listPublishers.add(new Publisher("Ejemplo Editorial"));
    }

    public int getIndexBookByISB(String ISB) {
        for (int i = 0; 1 < listBooks.size(); i++) {
            if (listBooks.get(i).getISB()
                    .equalsIgnoreCase(ISB)) {
                return i;
            }
        }
        return -1;
    }

    public int getIndexBookByTitle(String title) {
        for (int i = 0; 1 < listBooks.size(); i++) {
            if (listBooks.get(i).getTitle()
                    .equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1;
    }

    public int getIndexClientById(int id) {
        for (int i = 0; 1 < listClients.size(); i++) {
            if (listClients.get(i).getID() == id) {
                return i;
            }
        }
        return -1;
    }

    public int getIndexReservationById(int id) {
        for (int i = 0; 1 < listReservations.size(); i++) {
            if (listReservations.get(i).getID() == id) {
                return i;
            }
        }
        return -1;
    }

    public int getIndexLoanById(int id) {
        for (int i = 0; 1 < listLoans.size(); i++) {
            if (listLoans.get(i).getID() == id) {
                return i;
            }
        }
        return -1;
    }

    public List<Book> getListBooks() {
        return listBooks;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<Author> getListAuthors() {
        return listAuthors;
    }

    public List<Loan> getListLoans() {
        return listLoans;
    }

    public List<Client> getListClients() {
        return listClients;
    }

    public List<Publisher> getListPublishers() {
        return listPublishers;
    }

    public List<Reservation> getListReservations() {
        return listReservations;
    }

}
