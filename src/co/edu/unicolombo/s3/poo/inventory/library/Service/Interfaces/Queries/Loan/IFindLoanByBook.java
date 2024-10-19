package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Loan;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Book;
import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Loan;

public interface IFindLoanByBook {
    
    public Loan findLoanByBook(Book book) throws Exception;
}
