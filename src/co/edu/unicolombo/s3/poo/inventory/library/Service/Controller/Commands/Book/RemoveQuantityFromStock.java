
package co.edu.unicolombo.s3.poo.inventory.library.Service.Controller.Commands.Book;

import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Repositories.BookRepository;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Commands.Book.IRemoveStockCommands;

/**
 *
 * @author Juan
 */
public class RemoveQuantityFromStock implements  IRemoveStockCommands{
    
    private BookRepository bookRepository;

    public RemoveQuantityFromStock(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void removeStock(int amount, String title) throws Exception {
        bookRepository.removeBookFromStock(amount, title);
    }

    
}
