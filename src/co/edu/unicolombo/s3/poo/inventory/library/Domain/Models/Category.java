/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Domain.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Juan
 */
public class Category {
    private static int incrementID = 1;
    private int ID;
    private String name;
    private List<Book> books;

    public Category() {
        this.ID = incrementID++;
        this.books = new ArrayList<>();
    }

    public Category(String name) {
        this.ID = incrementID++;
        this.name = name;
        this.books = new ArrayList<>();
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Category category = (Category) o;
        return ID == category.ID;
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
