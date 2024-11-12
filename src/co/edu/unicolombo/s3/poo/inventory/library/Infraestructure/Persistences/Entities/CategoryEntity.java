package co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Table(name = "categories")
@Entity
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BookEntity> books;

    public CategoryEntity() {}

    public CategoryEntity(String name) {
        this.name = name;
        this.books = new ArrayList<>();
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

    public List<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(List<BookEntity> books) {
        this.books = books;
    }

    

}
