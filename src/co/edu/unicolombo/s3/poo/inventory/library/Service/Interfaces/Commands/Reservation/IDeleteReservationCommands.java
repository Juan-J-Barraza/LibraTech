/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Commands.Reservation;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Reservation;

/**
 *
 * @author Deiver Vasquez
 */
public interface IDeleteReservationCommands {

    public void deleteReservation(Reservation reservation) throws Exception;
}
