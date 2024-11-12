
package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Commands.Book;

import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.BookEntity;
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
    public void updateBook(BookEntity book) throws Exception {
        bookRepository.updateBook(book);
    }
}
