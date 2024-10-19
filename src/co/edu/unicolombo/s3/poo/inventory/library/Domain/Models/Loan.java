/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Domain.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 *
 * @author Juan
 */
public class Loan {

    private int ID;
    private int incemenetID;
    private Date dateLoan;
    private Date dateReturn;
    private int  quantity;
    private Client client;
    private List<Book> books;

    public Loan() {
        this.books = new ArrayList<>();
    }

    public Loan(Date dateLoan, Date dateReturn, Client client, int quantity) {
        this.ID = incemenetID++;
        this.dateLoan = dateLoan;
        this.dateReturn = dateReturn;
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

    public Date getDateLoan() {
        return dateLoan;
    }

    public void setDateLoan(Date dateLoan) {
        this.dateLoan = dateLoan;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(Date dateReturn) {
        this.dateReturn = dateReturn;
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
