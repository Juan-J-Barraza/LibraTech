package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Queries.Book;

import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.BookEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Book.IGetBooByISB;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.IBookRepository;

/**
 *
 * @author Juan
 */
public class GetBookByISB implements IGetBooByISB {

    private IBookRepository bookRepository;

    public GetBookByISB(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookEntity getBookByISB(String ISB) throws Exception {
        return bookRepository.getBookByISB(ISB);
    }

}
