/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Juan
 */
public class Inventory {
    private Map<String, List<Book>> listBooks;

    public Inventory() {
        listBooks = new HashMap<>();
    }
    
}
