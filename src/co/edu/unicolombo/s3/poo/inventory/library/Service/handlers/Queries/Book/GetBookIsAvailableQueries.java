package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Queries.Book;

import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.BookEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Book.IGetBookIsAvailable;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.IBookRepository;

public class GetBookIsAvailableQueries implements IGetBookIsAvailable {

    private IBookRepository repository;

    public GetBookIsAvailableQueries(IBookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Boolean bookIsAvailable(BookEntity book) {
        return repository.bookIsAvailable(book);
    }

}
