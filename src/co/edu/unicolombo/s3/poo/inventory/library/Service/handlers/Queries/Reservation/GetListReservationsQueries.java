/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Queries.Reservation;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Reservation;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Reservation.IGetListReservationsQueries;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.IReservationRepository;
import java.util.List;

/**
 *
 * @author Deiver Vasquez
 */
public class GetListReservationsQueries implements IGetListReservationsQueries {

    private final IReservationRepository repository;
    
    public GetListReservationsQueries(IReservationRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public List<Reservation> getAllReservations() throws Exception {
        return this.repository.getReservations();
    }
    
}
