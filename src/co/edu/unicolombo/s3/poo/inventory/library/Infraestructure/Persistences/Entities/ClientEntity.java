package co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities;

// import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Table(name = "clients")
@Entity
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String address;
    private String phoneNumber;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<LoanEntity> loans;

    @OneToMany(mappedBy = "client", fetch =  FetchType.EAGER)
    private List<ReservationEntity> reservations;

    public ClientEntity() {
    }

    public ClientEntity(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.loans = new HashSet<>();
    }

    @Override
    public String toString() {
        return this.name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<LoanEntity> getLoans() {
        return loans;
    }

    public void setLoans(Set<LoanEntity> loans) {
        this.loans = loans;
    }

}
