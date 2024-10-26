package co.edu.unicolombo.s3.poo.inventory.library.Service.Controller.Queries.Book;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Book;
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
    public Book getBookByISB(String ISB) throws Exception {
        return bookRepository.getBookByISB(ISB);
    }

}
