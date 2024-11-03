/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Commands.Reservation;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Reservation;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Commands.Reservation.IDeleteReservationCommands;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.IReservationRepository;

/**
 *
 * @author Deiver Vasquez
 */
public class DeleteReservationCommands implements IDeleteReservationCommands {
    
    private final IReservationRepository repository;
    
    public DeleteReservationCommands(IReservationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void deleteReservation(Reservation reservation) throws Exception {
        this.repository.deleteReservation(reservation);
    }
}
