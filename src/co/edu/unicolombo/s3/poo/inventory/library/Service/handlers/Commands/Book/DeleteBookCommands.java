/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Commands.Book;

import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.BookEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Commands.Book.IDeleteBookCommands;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.IBookRepository;

/**
 *
 * @author Juan
 */
public class DeleteBookCommands implements IDeleteBookCommands{
    
    private IBookRepository bookRepository;
    
    
    public DeleteBookCommands(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    @Override
    public void deleteBook(BookEntity book) throws Exception {
        bookRepository.deleteBook(book);
    }
    
}
