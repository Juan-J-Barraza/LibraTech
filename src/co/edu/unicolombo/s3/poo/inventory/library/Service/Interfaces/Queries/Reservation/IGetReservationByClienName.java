package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Reservation;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Reservation;

public interface IGetReservationByClienName {

    public Reservation getReservationByClienName(String name)
            throws Exception;
}
