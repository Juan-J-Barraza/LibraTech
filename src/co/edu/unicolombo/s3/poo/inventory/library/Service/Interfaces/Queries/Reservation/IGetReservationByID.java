package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Reservation;

// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Reservation;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.ReservationEntity;

public interface IGetReservationByID {
    
    public ReservationEntity getReservationByID(int ID) throws Exception;
}
