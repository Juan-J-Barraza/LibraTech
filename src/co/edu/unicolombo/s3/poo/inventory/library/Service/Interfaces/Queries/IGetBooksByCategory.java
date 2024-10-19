
package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Book;
import java.util.List;

/**
 *
 * @author Juan
 */
public interface IGetBooksByCategory {
    
    public List<Book> getBooksByCategory(String name) throws Exception;
}
