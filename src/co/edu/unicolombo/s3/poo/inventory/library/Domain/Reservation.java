/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Juan
 */
public class Reservation {
    private static int incrementID;
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
