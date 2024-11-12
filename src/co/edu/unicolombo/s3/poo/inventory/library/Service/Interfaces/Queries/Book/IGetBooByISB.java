
package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Book;

import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.BookEntity;

/**
 *
 * @author Juan
 */
public interface IGetBooByISB {

    public BookEntity getBookByISB(String ISB) throws Exception;
}
