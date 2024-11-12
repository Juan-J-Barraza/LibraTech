/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Repositories;

// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Reservation;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Config.HibernateUtil;
// import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.DB;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.ReservationEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.IReservationRepository;
import java.util.List;
// import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Deiver Vasquez
 */
public class ReservationRepository implements IReservationRepository {

    private final SessionFactory sessionFactory;

    public ReservationRepository() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void addReservation(ReservationEntity reservation) throws Exception {
        if (reservation == null) {
            throw new Exception("Reservation is null");
        }
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(reservation);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null && session.getTransaction().getStatus().canRollback()) {
                session.getTransaction().rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public List<ReservationEntity> getReservations() throws Exception {
        Session session = sessionFactory.openSession();
        try {
            var reservations = session.createQuery("FROM ReservationEntity", ReservationEntity.class).list();

            if (reservations.isEmpty()) {
                throw new Exception("the reservation is empty");
            }

            return reservations;

        } finally {
            session.close();
        }
    }

    @Override
    public void updateReservation(ReservationEntity reservation) throws Exception {
        if (reservation == null) {
            throw new Exception("The reservation is null");
        }
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            ReservationEntity newReservation = session.get(ReservationEntity.class, reservation.getId());
            if (newReservation == null) {
                throw new Exception("the reservation is null");
            }

            newReservation.setQuantity(reservation.getQuantity());
            newReservation.setBookEntity(reservation.getBookEntity());
            newReservation.setClientEntity(reservation.getClientEntity());
            newReservation.setDateReservation(reservation.getDateReservation());

            session.update(newReservation);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null && session.getTransaction().getStatus().canRollback()) {
                session.getTransaction().rollback();
            }
            throw e;

        } finally {
            session.close();
        }
    }

    @Override
    public void deleteReservation(ReservationEntity reservation) throws Exception {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            ReservationEntity deleteResv = session.get(ReservationEntity.class, reservation.getId());
            session.delete(deleteResv);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null && session.getTransaction().getStatus().canRollback()) {
                session.getTransaction().rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public ReservationEntity getReservationByID(int ID) throws Exception {
        if (ID == 0) {
            throw new Exception("Id is 0");
        }

        Session session = sessionFactory.openSession();
        try {
            ReservationEntity rEntity = session.createQuery("FROM ReservationEntity WHERE id = :id",
                    ReservationEntity.class).setParameter("id", ID)
                    .uniqueResult();
            return rEntity;
        } finally {
            session.close();
        }
    }

    // @Override
    // public int getIndexReservationByID(int ID) throws Exception {

    // for (int i = 0; i < db.getListReservations().size(); i++) {
    // if (db.getListReservations().get(i).getID() == ID) {
    // return i;
    // }
    // }

    // return -1;
    // }

    // @Override
    // public boolean bookIsAvailable(String title) {
    // var indexBook = db.getIndexBookByTitle(title);
    // var isAviableBook = db.getListBooks().get(indexBook).isAvailable();
    // var isStockBook = db.getListBooks().get(indexBook).getStock() > 0;
    // return isAviableBook && isStockBook;
    // }

    @Override
    public ReservationEntity getReservationByNameClient(String name) throws Exception {
        if (name == null || name.trim().isEmpty()) {
            throw new Exception("The client name is null or empty.");
        }
        Session session = sessionFactory.openSession();
        try {
            ReservationEntity rEntity = session.createQuery(
                    "FROM ReservationEntity r WHERE LOWER(r.client.name) = :name",
                    ReservationEntity.class)
                    .setParameter("name", name.toLowerCase())
                    .uniqueResult();
            if (rEntity == null) {
                throw new Exception("the client not found");
            }
            System.out.println("Reservation found for client: " + name);
            return rEntity;
        } finally {
            session.close();
        }
    }
}
