/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Domain.Models;

import java.util.Date;
import java.util.Objects;
/**
 *
 * @author Juan
 */
public class Book {

    private String ISB;
    private String title;
    private Date publicaion;
    private boolean available;
    private int stock;
    private Publisher publisher;
    private Category category;

    public Book() {

    }

    public Book(String ISB, String title, Date publicaion,
            int stock, Publisher publisher, Category category) {
        this.ISB = ISB;
        this.title = title;
        this.publicaion = publicaion;
        this.available = true;
        this.stock = stock;
        this.publisher = publisher;
        this.category = category;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return ISB.equals(book.ISB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ISB); 
    }

    public String getISB() {
        return ISB;
    }

    public void setISB(String ISB) {
        this.ISB = ISB;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublicaion() {
        return publicaion;
    }

    public void setPublicaion(Date publicaion) {
        this.publicaion = publicaion;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}