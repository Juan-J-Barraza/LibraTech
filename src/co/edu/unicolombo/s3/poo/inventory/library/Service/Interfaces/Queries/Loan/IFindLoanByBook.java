package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Loan;

// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Book;
// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Loan;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.BookEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.LoanEntity;

public interface IFindLoanByBook {
    
    public LoanEntity findLoanByBook(BookEntity book) throws Exception;
}
