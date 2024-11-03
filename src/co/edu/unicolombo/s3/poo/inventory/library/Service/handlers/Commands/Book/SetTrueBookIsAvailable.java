package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Commands.Book;

import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Repositories.BookRepository;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Commands.Book.ISetTrueIsAvailableBookCommands;

public class SetTrueBookIsAvailable implements ISetTrueIsAvailableBookCommands {

    private BookRepository bookRepository;

    public SetTrueBookIsAvailable(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void setTrueIsAvailable(String ISB) throws Exception {
        bookRepository.bookIsTrueAvailable(ISB);
    }

}
