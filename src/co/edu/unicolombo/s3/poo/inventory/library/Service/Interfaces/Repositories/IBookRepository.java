/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Book;
import java.util.List;

/**
 *
 * @author Juan
 */
public interface IBookRepository {

    public void addBook(Book book) throws Exception;

    public List<Book> getListBooks() throws Exception;

    public Book getBookByISB(String ISB) throws Exception;

    public void updateBook(Book newBook) throws Exception;

    public void deleteBook(Book book) throws Exception;

    public boolean bookIsAvailable(String title);

    public boolean bookIsFalseAvailable(String ISB) throws Exception;
    
    public void bookIsTrueAvailable(String ISB) throws Exception;

    public void addBookToStock(int amount, String title) throws Exception;

    public void removeBookFromStock(int amount, String title) throws Exception;

    }
