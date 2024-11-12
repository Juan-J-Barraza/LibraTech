package co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities;

import java.sql.Date;
// import java.util.ArrayList;
import java.util.HashSet;
// import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Table(name = "loans")
@Entity
public class LoanEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @Column(name = "date_loan")
    private Date dateLoan;

    @Column(name = "date_Return")
    private Date dateReturn;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private ClientEntity client;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "book_loan", 
               joinColumns = @JoinColumn(name = "loan_id"), 
               inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<BookEntity> books;

    public LoanEntity() {
        this.books = new HashSet<>();

    }

    public LoanEntity(Date dateLoan, Date dateReturn, int quantity, ClientEntity client) {
        this.dateLoan = dateLoan;   
        this.dateReturn = dateReturn;
        this.quantity = quantity;
        this.client = client;
        this.books = new HashSet<>();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateLoan() {
        return dateLoan;
    }

    public void setDateLoan(Date dateLoan) {
        this.dateLoan = dateLoan;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(Date dateReturn) {
        this.dateReturn = dateReturn;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public Set<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(Set<BookEntity> books) {
        this.books = books;
    }

    
}
