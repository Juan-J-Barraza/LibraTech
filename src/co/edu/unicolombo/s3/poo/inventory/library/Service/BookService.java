package co.edu.unicolombo.s3.poo.inventory.library.Service;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Book;
import co.edu.unicolombo.s3.poo.inventory.library.Domain.Db;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Juan
 */
public class BookService {

    private final Db db = Db.getInstance();

    public void addBook(Book book) {
        db.getListBooks().add(book);
    }

    public List<Book> getListBooks() throws Exception{
        var books = db.getListBooks();
        if (books == null || books.isEmpty()) {
            throw new Exception("the list is empty or null");
        }
        return books;
    }

    public Book getBook(String ISB)
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

    public void updateBook(String ISB, Book newBook)
            throws Exception {
        if (newBook != null && ISB != null) {
            var indexBook = db.getIndexBookByISB(ISB);
            if (indexBook >= 0) {
                db.getListBooks().set(indexBook, newBook);
            }
            throw new Exception("The book is not created");
        }
        throw new Exception("The new book or title are null");
    }

    public void deleteBook(Book book)
            throws Exception {
        if (book != null) {
            var indexBook = db.getIndexBookByISB(book.getISB());
            db.getListBooks().remove(indexBook);
        }
        throw new Exception("The book is not deleted");
    }

    public boolean bookIsAvailable(String title) {
        var indexBook = db.getIndexBookByTitle(title);
        var isAviableBook = db.getListBooks().get(indexBook).isAvailable();
        var isStockBook = db.getListBooks().get(indexBook).getStock() > 0;
        return isAviableBook && isStockBook;
    }

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

}
