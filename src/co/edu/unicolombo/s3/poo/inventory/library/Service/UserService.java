/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Service;

//import co.edu.unicolombo.s3.poo.inventory.library.Domain.User;


/**
 *
 * @author Juan
 */
public class UserService {
    private static UserService instance;
    
    private UserService() {
    }
    
    public static UserService getinstance() {
        if(instance == null) {
            instance = new UserService();
        }
        return instance;
    }
    
}
