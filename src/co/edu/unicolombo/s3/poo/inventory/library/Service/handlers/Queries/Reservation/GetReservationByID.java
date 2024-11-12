package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Queries.Reservation;

// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Reservation;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.ReservationEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Reservation.IGetReservationByID;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.IReservationRepository;

public class GetReservationByID  implements IGetReservationByID{

    public IReservationRepository reservationRepository;

    
    public GetReservationByID(IReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }


    @Override
    public ReservationEntity getReservationByID(int ID) throws Exception {
        return reservationRepository.getReservationByID(ID);
    }
    
}
