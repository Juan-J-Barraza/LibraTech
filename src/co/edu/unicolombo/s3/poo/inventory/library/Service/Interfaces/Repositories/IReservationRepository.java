/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories;

// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Reservation;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.ReservationEntity;

import java.util.List;

/**
 *
 * @author Deiver Vasquez
 */
public interface IReservationRepository {
    
    public void addReservation(ReservationEntity reservation) 
            throws Exception;
    
    public List<ReservationEntity> getReservations()
            throws Exception;
    
    public void updateReservation(ReservationEntity reservation)
            throws Exception;
    
     public void deleteReservation(ReservationEntity reservation)
            throws Exception;

     public ReservationEntity getReservationByID(int ID)
             throws Exception;
     
//      public int getIndexReservationByID(int ID)
//              throws Exception;
     
//      public boolean bookIsAvailable(String title);

     public ReservationEntity getReservationByNameClient(String name) throws Exception;
}
