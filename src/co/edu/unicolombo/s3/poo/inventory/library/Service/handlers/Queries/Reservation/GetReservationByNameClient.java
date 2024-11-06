package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Queries.Reservation;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Reservation;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Reservation.IGetReservationByClienName;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.IReservationRepository;

public class GetReservationByNameClient implements IGetReservationByClienName {

    private final IReservationRepository repository;
    
    public GetReservationByNameClient(IReservationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Reservation getReservationByClienName(String name) throws Exception {
        return repository.getReservationByNameClient(name);
    }
    
}
