/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Repositories;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Reservation;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.DB;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.IReservationRepository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Deiver Vasquez
 */
public class ReservationRepository implements IReservationRepository {

    private final DB db = DB.getInstance();

    @Override
    public void addReservation(Reservation reservation) throws Exception {

        boolean exists = db.getListReservations().stream()
                .anyMatch(existingReservation -> existingReservation.getID() == reservation.getID());

        if (exists) {
            throw new Exception("The reservation with the same ID already Exist");
        }

        db.getListReservations().add(reservation);
    }

    @Override
    public List<Reservation> getReservations() throws Exception {

        List<Reservation> reservations = db.getListReservations();

        if (reservations == null || reservations.isEmpty()) {
            throw new Exception("the list is empty or null");
        }

        return reservations;
    }

    @Override
    public void updateReservation(Reservation reservation) throws Exception {

        if (reservation == null) {
            throw new Exception("The reservation is null");
        }

        int indexReservation = this.getIndexReservationByID(reservation.getID());
        if (indexReservation < 0) {
            throw new Exception("The new reservation does not exist");
        }

        db.getListReservations().set(indexReservation, reservation);
    }

    @Override
    public void deleteReservation(Reservation reservation) throws Exception {

        if (!db.getListReservations().contains(reservation)) {
            throw new Exception("The reservation does not exist");
        }

        boolean removeReservation = db.getListReservations().remove(reservation);
        if (!removeReservation) {
            throw new Exception("The reservation could not be delete");
        }
    }

    @Override
    public Reservation getReservationByID(int ID) throws Exception {

        Optional<Reservation> firstReservation = db.getListReservations().stream()
                .filter(r -> r.getID() == ID)
                .findFirst();

        if (!firstReservation.isPresent()) {
            throw new Exception("Reservation not found with ID: " + ID);
        }

        return firstReservation.get();
    }

    @Override
    public int getIndexReservationByID(int ID) throws Exception {

        for (int i = 0; i < db.getListReservations().size(); i++) {
            if (db.getListReservations().get(i).getID() == ID) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public boolean bookIsAvailable(String title) {
        var indexBook = db.getIndexBookByTitle(title);
        var isAviableBook = db.getListBooks().get(indexBook).isAvailable();
        var isStockBook = db.getListBooks().get(indexBook).getStock() > 0;
        return isAviableBook && isStockBook;
    }

    @Override
    public Reservation getReservationByNameClient(String name) throws Exception {
        if (name == null) {
            System.out.println("entrando al if");
            throw new Exception("The client does not have a reservation");
        }

        Optional<Reservation> reservation = db.getListReservations().stream()
                .filter(c -> c.getClient().getName().equalsIgnoreCase(name))
                .findFirst();
        if (reservation.isEmpty()) {
            throw new Exception("No reservation found for the client: " + name);
        }
        System.out.println("no entro al if y retorno: " + reservation.get());
        return reservation.get();
    }
}
