
package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Commands.Book;

import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Commands.Book.IRemoveStockCommands;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.IBookRepository;

/**
 *
 * @author Juan
 */
public class RemoveQuantityFromStock implements  IRemoveStockCommands{
    
    private IBookRepository bookRepository;

    public RemoveQuantityFromStock(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void removeStock(int amount, String title) throws Exception {
        bookRepository.removeBookFromStock(amount, title);
    }

    
}
