package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Commands.Reservation;

// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Reservation;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.ReservationEntity;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Deiver Vasquez
 */
public interface IAddReservationCommands {

    public void createReservation(ReservationEntity reservation) throws Exception;
}
