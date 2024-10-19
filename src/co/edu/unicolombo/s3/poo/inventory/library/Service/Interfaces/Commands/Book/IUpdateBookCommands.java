package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Commands.Book;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Book;

/**
 *
 * @author Juan
 */
public interface IUpdateBookCommands {

    public void updateBook(Book book) throws Exception;
}
