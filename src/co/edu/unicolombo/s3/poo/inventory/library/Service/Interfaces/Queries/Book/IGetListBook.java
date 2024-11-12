
package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Book;

import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.BookEntity;

import java.util.List;

/**
 *
 * @author Juan
 */
public interface IGetListBook {
    
    public List<BookEntity> getAllBooks() throws Exception;
}
