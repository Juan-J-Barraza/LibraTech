
package co.edu.unicolombo.s3.poo.inventory.library.Service.Controller.Commands.Book;

import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Repositories.BookRepository;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Commands.Book.IBooktoFalseCommands;

/**
 *
 * @author Juan
 */
public class SetBookToFalseAviailable implements IBooktoFalseCommands {

    private BookRepository bookRepository;

    public SetBookToFalseAviailable(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public boolean bookSetTofalseAvailable(String ISB) throws Exception {
        return bookRepository.bookIsFalseAvailable(ISB);
    }

}
