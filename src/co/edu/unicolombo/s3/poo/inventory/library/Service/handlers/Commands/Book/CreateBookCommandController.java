package co.edu.unicolombo.s3.poo.inventory.library.Service.Controller.Commands.Book;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Book;
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
    public void createBook(Book book) throws Exception {
        bookRepository.addBook(book);
    }

}
