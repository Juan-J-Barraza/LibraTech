package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Queries.Reservation;

// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Reservation;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.ReservationEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Reservation.IGetReservationByClienName;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.IReservationRepository;

public class GetReservationByNameClient implements IGetReservationByClienName {

    private final IReservationRepository repository;
    
    public GetReservationByNameClient(IReservationRepository repository) {
        this.repository = repository;
    }

    @Override
    public ReservationEntity getReservationByClienName(String name) throws Exception {
        return repository.getReservationByNameClient(name);
    }
    
}
