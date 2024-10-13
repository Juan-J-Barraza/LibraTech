/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan
 */
public class Client {
    private static int incrementID;
    private int ID;
    private String name;
    private String address;
    private String phoneNumber;
    private List<Loan> loans;
    
    public Client() {
        this.ID = incrementID++;
        this.loans = new ArrayList<>();
    }
    public Client(String name, String address, String phoneNumber) {
        this.ID = incrementID++;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.loans = new ArrayList<>();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
    
}
