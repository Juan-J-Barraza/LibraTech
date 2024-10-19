
package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Book;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Book;
import java.util.List;

/**
 *
 * @author Juan
 */
public interface IGetListBook {
    
    public List<Book> getAllBooks() throws Exception;
}
