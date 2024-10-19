/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Domain.Models;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan
 */
public class Publisher {
    private static int incrementID;
    private int ID;
    private String name;
    private List<Book> books;

    public Publisher() {
        this.ID = incrementID++;
        this.books = new ArrayList<>();
    }

    public Publisher(String name) {
        this.ID = incrementID++;
        this.name = name;
        this.books = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    

}
