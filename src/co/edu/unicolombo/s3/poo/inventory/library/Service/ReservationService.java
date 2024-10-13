package co.edu.unicolombo.s3.poo.inventory.library.Service;

import java.util.List;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.*;

/**
 *
 * @author Juan
 */
public class ReservationService {

    private final Db db = Db.getInstance();

    public void addReservation(int quantity, Reservation reservation)
            throws Exception {
        if (quantity == 0 && reservation == null) {
            throw new Exception();
        }
        db.getListReservations().add(reservation);
    }

    public void updateReservation(int idReser, Reservation reservation)
            throws Exception {
        if (idReser == 0 && reservation == null) {
            throw new Exception();
        }
        var indexReser = db.getIndexReservationById(idReser);
        db.getListReservations().set(indexReser, reservation);
    }

    public void deleteReservation(Reservation reservation)
            throws Exception {
        if (reservation == null) {
            throw new Exception();
        }
        var indexRs = db.getIndexReservationById(reservation.getID());
        db.getListReservations().remove(indexRs);
    }

    public List<Reservation> getReservations()
            throws Exception {
        if(db.getListReservations().isEmpty()) {
            throw new Exception("The list is empty");
        }

        return db.getListReservations();
    }
    

}