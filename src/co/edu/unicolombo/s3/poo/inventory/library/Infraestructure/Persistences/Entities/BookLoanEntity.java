package co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities;

import javax.persistence.*;

@Entity
@Table(name = "book_loan")
public class BookLoanEntity {
    @EmbeddedId
    private BookLoanId id = new BookLoanId();

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "book_id", nullable = false)
    private BookEntity book;

    @ManyToOne
    @MapsId("loanId")
    @JoinColumn(name = "loan_id", nullable = false)
    private LoanEntity loan;

    
   

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public LoanEntity getLoan() {
        return loan;
    }

    public void setLoan(LoanEntity loan) {
        this.loan = loan;
    }

    public BookLoanId getId() {
        return id;
    }

    public void setId(BookLoanId id) {
        this.id = id;
    }
}
