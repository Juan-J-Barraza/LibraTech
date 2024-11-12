package co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Column;

@Embeddable
public class BookLoanId implements Serializable {
    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "loan_id")
    private Long loanId;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    
}
