package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Loan;

import java.util.List;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Loan;

public interface IGetBooksWithLoansByCategory {
    
    public List<Loan> getBooksByCategoryWithLoans(String name) throws Exception;
}
