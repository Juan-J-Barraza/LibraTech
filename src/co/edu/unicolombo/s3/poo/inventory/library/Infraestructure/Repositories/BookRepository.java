package co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Repositories;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Book;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.DB;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.IBookRepository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Juan
 */
public class BookRepository implements IBookRepository {

    private final DB db = DB.getInstance();

    @Override
    public void addBook(Book book) throws Exception {
        boolean exists = db.getListBooks().stream()
                .anyMatch(existingBook -> existingBook.getISB()
                        .equalsIgnoreCase(book.getISB()));
        if (exists) {
            throw new Exception("The book with ISB already Exist");
        }
        db.getListBooks().add(book);
    }

    @Override
    public List<Book> getListBooks() throws Exception {
        var books = db.getListBooks();
        if (books == null || books.isEmpty()) {
            throw new Exception("the list is empty or null");
        }
        return books;
    }

    @Override
    public Book getBookByISB(String ISB)
            throws Exception {
        if (ISB != null) {
            Optional<Book> firstBook = db.getListBooks().stream()
                    .filter(b -> b.getTitle()
                            .equalsIgnoreCase(ISB))
                    .findFirst();

            if (!firstBook.isPresent()) {
                throw new Exception("not found that book");
            }
            return firstBook.get();
        }
        return null;
    }

    @Override
    public void updateBook(Book newBook) throws Exception {
        if (newBook == null) {
            throw new Exception("The book is null");
        }
        var indexBook = db.getIndexBookByISB(newBook.getISB());
        if (indexBook < 0) {
            throw new Exception("The new book does not exist");
        }
        db.getListBooks().set(indexBook, newBook);
    }

    @Override
    public void deleteBook(Book book) throws Exception {
        if (!db.getListBooks().contains(book)) {
            throw new Exception("The book does not exist in the list.");
        }

        boolean removeBook = db.getListBooks().remove(book);
        if (!removeBook) {
            throw new Exception("The book could not be delete");
        }
    }

    @Override
    public boolean bookIsAvailable(String title) {
        var indexBook = db.getIndexBookByTitle(title);
        var isAviableBook = db.getListBooks().get(indexBook).isAvailable();
        var isStockBook = db.getListBooks().get(indexBook).getStock() > 0;
        return isAviableBook && isStockBook;
    }

    @Override
    public void addBookToStock(int amount, String title) throws Exception {
        if (amount > 0) {
            var indexBook = db.getIndexBookByTitle(title);
            if (indexBook >= 0) {
                int newStock = db.getListBooks().get(indexBook).getStock() + amount;
                db.getListBooks().get(indexBook).setStock(newStock);
            } else {
                throw new Exception("The index is lower");
            }
        } else {
            throw new Exception("The amount should be heigher to 0");
        }
    }

    @Override
    public void removeBookFromStock(int amount, String title) throws Exception {
        var indexStock = db.getIndexBookByTitle(title);
        var getStock = db.getListBooks().get(indexStock).getStock();
        if (amount > 0 && getStock >= amount) {
            int newStock = getStock - amount;
            db.getListBooks().get(indexStock).setStock(newStock);
        } else {
            throw new Exception("Stock insuficiente o monto inválido");
        }
    }

    @Override
    public boolean bookIsFalseAvailable(String ISB) throws Exception {
        var indexBook = db.getIndexBookByISB(ISB);
        if (indexBook < 0) {
            throw new Exception("The book with the provided ISBN does not exist");
        }
        var book = db.getListBooks().get(indexBook);
        var getStock = book.getStock();
        if (getStock > 0) {
            return true;
        }
        book.setAvailable(false);
        return false;
    }

}
