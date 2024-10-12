/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Domain;

/**
 *
 * @author Juan
 */
public class User {
    private int ID;
    private String name;
    private String phoneNumber;
    private String password;
    private String typeUser;
    private Inventory inventory;

    public User() {
    }

    public User(String name, String phoneNumber, String password, String typeUser, Inventory inventory) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.typeUser = typeUser;
        this.inventory = inventory;
        this.password = password;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
