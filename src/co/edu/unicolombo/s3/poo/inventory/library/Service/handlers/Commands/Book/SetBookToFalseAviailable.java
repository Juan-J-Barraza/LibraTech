
package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Commands.Book;

import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Commands.Book.IBooktoFalseCommands;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.IBookRepository;

/**
 *
 * @author Juan
 */
public class SetBookToFalseAviailable implements IBooktoFalseCommands {

    private IBookRepository bookRepository;

    public SetBookToFalseAviailable(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public boolean bookSetTofalseAvailable(String ISB) throws Exception {
        return bookRepository.bookIsFalseAvailable(ISB);
    }

}
