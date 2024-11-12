/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories;


import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.BookEntity;

import java.util.List;

/**
 *
 * @author Juan
 */
public interface IBookRepository {

    public void addBook(BookEntity book) throws Exception;

    public List<BookEntity> getListBooks() throws Exception;

    public BookEntity getBookByISB(String ISB) throws Exception;

    public BookEntity getBookByTitle(String title) throws Exception;

    public void updateBook(BookEntity newBook) throws Exception;

    public void deleteBook(BookEntity book) throws Exception;

    public boolean bookIsAvailable(BookEntity book);

    public boolean bookIsFalseAvailable(String ISB) throws Exception;
    
    public void bookIsTrueAvailable(String ISB) throws Exception;

    public void addBookToStock(int amount, String title) throws Exception;

    public void removeBookFromStock(int amount, String title) throws Exception;

    }
