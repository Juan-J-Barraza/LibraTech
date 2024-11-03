
package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Commands.Book;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Book;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Commands.Book.IUpdateBookCommands;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.IBookRepository;

/**
 *
 * @author Juan
 */
public class UpdateBookCommandController implements IUpdateBookCommands {
    
    private IBookRepository bookRepository;
    
    
    public UpdateBookCommandController(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void updateBook(Book book) throws Exception {
        bookRepository.updateBook(book);
    }
}
