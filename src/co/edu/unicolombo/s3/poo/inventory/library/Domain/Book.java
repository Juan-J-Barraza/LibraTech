/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Domain;

import java.util.Date;

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
    private Loan loan;
    private Reservation reservation;
    private Inventory inventory;
    
    public Book() {
        
    }

    public Book(String ISB, String title, Date publicaion, boolean available, 
            int stock, Publisher publisher, Category category, Loan loan, 
            Reservation reservation, Inventory inventory) {
        this.ISB = ISB;
        this.title = title;
        this.publicaion = publicaion;
        this.available = available = true;
        this.stock = stock = 1;
        this.publisher = publisher;
        this.category = category;
        this.loan = loan;
        this.reservation = reservation;
        this.inventory = inventory;
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

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    
    
}