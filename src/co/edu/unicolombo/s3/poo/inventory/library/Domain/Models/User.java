/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Domain.Models;

/**
 *
 * @author Juan
 */
public class User {
    private String name;
    private String phoneNumber;
    private Inventory inventory;

    public User() {
    }

    public User(String name, String phoneNumber, Inventory inventory) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.inventory = inventory;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
  
    
}
