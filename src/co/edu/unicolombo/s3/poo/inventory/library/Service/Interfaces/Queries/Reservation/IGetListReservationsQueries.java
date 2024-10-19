/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Reservation;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Reservation;
import java.util.List;

/**
 *
 * @author Deiver Vasquez
 */
public interface IGetListReservationsQueries {
    
    public List<Reservation> getAllReservations() throws Exception;
}
