package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Commands.Book;

import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.BookEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Commands.Book.IAddCommands;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.IBookRepository;

/**
 *
 * @author Juan
 */
public class CreateBookCommandController implements IAddCommands {

    private IBookRepository bookRepository;
    
    public CreateBookCommandController(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    
    @Override
    public void createBook(BookEntity book) throws Exception {
        bookRepository.addBook(book);
    }

}
