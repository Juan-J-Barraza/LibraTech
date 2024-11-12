package co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities;

import javax.persistence.*;

import java.util.Set;
import java.sql.Date;
import java.util.HashSet;
// import java.util.List;

@Table(name = "books")
@Entity
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "isbn", nullable = false, unique = true)
    private String ISB;

    private String title;

    @Column(name = "publication_date")
    private Date publication;

    private boolean available;

    private int stock;

    @ManyToOne
    @JoinColumn(name = "publisher_id", nullable = false)
    private PublisherEntity publisher;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "book_loan", 
        joinColumns = @JoinColumn(name = "book_id"), 
        inverseJoinColumns = @JoinColumn(name = "loan_id")
    )
    private Set<LoanEntity> loans = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "book_id")
    private BookEntity bookEntity;

    public BookEntity() {
        this.loans = new HashSet<>();
    }

    public BookEntity(String iSB, String title, Date publication, int stock,
            PublisherEntity publisher, CategoryEntity category) {
        ISB = iSB;
        this.title = title;
        this.publication = publication;
        this.available = true;
        this.stock = stock;
        this.publisher = publisher;
        this.category = category;
        this.loans = new HashSet<>();
    }

    @Override
    public String toString() {
        return this.title;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getISB() {
        return ISB;
    }

    public void setISB(String iSB) {
        ISB = iSB;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublication() {
        return publication;
    }

    public void setPublication(Date publication) {
        this.publication = publication;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public PublisherEntity getPublisherEntity() {
        return publisher;
    }

    public void setPublisherEntity(PublisherEntity publisher) {
        this.publisher = publisher;
    }

    public CategoryEntity getCategoryEntity() {
        return category;
    }

    public void setCategoryEntity(CategoryEntity category) {
        this.category = category;
    }

    public void setPublisher(PublisherEntity publisher) {
        this.publisher = publisher;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public Set<LoanEntity> getLoans() {
        return loans;
    }

    public void setLoans(Set<LoanEntity> loans) {
        this.loans = loans;
    }

}