
package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Queries.Book;

import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.BookEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Book.IGetListBook;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.IBookRepository;
import java.util.List;

/**
 *
 * @author Juan
 */
public class GetListBookQueries implements IGetListBook{
    
    private IBookRepository bookRepository;
    
    public GetListBookQueries(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookEntity> getAllBooks() throws Exception {
         return bookRepository.getListBooks();
    }
    
    
}
