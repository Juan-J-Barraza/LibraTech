package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Commands.Book;

import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Commands.Book.ISetTrueIsAvailableBookCommands;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.IBookRepository;

public class SetTrueBookIsAvailable implements ISetTrueIsAvailableBookCommands {

    private IBookRepository bookRepository;

    public SetTrueBookIsAvailable(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void setTrueIsAvailable(String ISB) throws Exception {
        bookRepository.bookIsTrueAvailable(ISB);
    }

}
