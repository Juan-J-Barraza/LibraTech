package co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities;

import java.sql.Date;

import javax.persistence.*;

@Table(name = "reservations")
@Entity
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "date_reservation")
    private Date dateReservation;

    @ManyToOne()
    @JoinColumn(name = "client_id", nullable = false)
    private ClientEntity client;

    private int quantity;

    @OneToOne
    @JoinColumn(name = "book_id", nullable = false)
    private BookEntity bookEntity;

    public ReservationEntity() {
    }

    
    public ReservationEntity(Date dateReservation, ClientEntity clientEntity, int quantity, BookEntity bookEntity) {
        this.dateReservation = dateReservation;
        this.client = clientEntity;
        this.quantity = quantity;
        this.bookEntity = bookEntity;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public ClientEntity getClientEntity() {
        return client;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.client = clientEntity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BookEntity getBookEntity() {
        return bookEntity;
    }

    public void setBookEntity(BookEntity bookEntity) {
        this.bookEntity = bookEntity;
    }

    
}
