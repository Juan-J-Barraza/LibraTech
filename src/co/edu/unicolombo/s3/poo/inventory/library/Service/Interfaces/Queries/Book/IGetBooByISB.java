
package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Book;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Book;

/**
 *
 * @author Juan
 */
public interface IGetBooByISB {

    public Book getBookByISB(String ISB) throws Exception;
}
