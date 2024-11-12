package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Queries.Book;

import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.BookEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Book.IGetBookByTitle;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.IBookRepository;

public class GetBookBytitleQueries implements IGetBookByTitle {
    IBookRepository bookRepository;

    public GetBookBytitleQueries(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookEntity getBookByTitle(String title) throws Exception {
        return bookRepository.getBookByTitle(title);
    }

}
