/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Reservation;
import java.util.List;

/**
 *
 * @author Deiver Vasquez
 */
public interface IReservationRepository {
    
    public void addReservation(Reservation reservation) 
            throws Exception;
    
    public List<Reservation> getReservations()
            throws Exception;
    
    public void updateReservation(Reservation reservation)
            throws Exception;
    
     public void deleteReservation(Reservation reservation)
            throws Exception;

     public Reservation getReservationByID(int ID)
             throws Exception;
     
     public int getIndexReservationByID(int ID)
             throws Exception;
     
     public boolean bookIsAvailable(String title);
}
