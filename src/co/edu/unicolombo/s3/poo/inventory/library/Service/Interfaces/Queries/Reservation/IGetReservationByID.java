package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Reservation;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Reservation;

public interface IGetReservationByID {
    
    public Reservation getReservationByID(int ID) throws Exception;
}
