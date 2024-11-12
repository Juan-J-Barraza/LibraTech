
package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Commands.Book;

import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.BookEntity;

/**
 *
 * @author Juan
 */
public interface IDeleteBookCommands {
    
    public void deleteBook(BookEntity book) throws Exception;
}
