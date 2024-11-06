/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Domain.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Juan
 */
public class Reservation {
    private static int incrementID = 1;
    private int ID;
    private Date dateReservation;
    private Client client;
    private int quantity;
    private List<Book> books;

    public Reservation() {
        this.ID = incrementID++;
        this.books = new ArrayList<>();

    }

    public Reservation(Date dateReservation, Client client, int quantity) {
        this.ID = incrementID++;
        this.dateReservation = dateReservation;
        this.client = client;
        this.quantity = quantity;
        this.books = new ArrayList<>();
    }

    
     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation reservation = (Reservation) o;
        return ID == reservation.ID;
    }

    @Override
    public String toString() {
        return "revaID: " + this.ID;
    }
    @Override
    public int hashCode() {
        return Objects.hash(ID); 
    }
 
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Book> getBooks() {
        return books;
    }
    
    public void addBook(Book book) {
        this.getBooks().add(book);
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

   
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
