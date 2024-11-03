/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Commands.Reservation;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Reservation;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Commands.Reservation.IAddReservationCommands;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.IReservationRepository;

/**
 *
 * @author Deiver Vasquez
 */
public class AddReservationCommands implements IAddReservationCommands {

    private final IReservationRepository repository;
    
    public AddReservationCommands(IReservationRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public void createReservation(Reservation reservation) throws Exception {
        this.repository.addReservation(reservation);
    }
    
}
