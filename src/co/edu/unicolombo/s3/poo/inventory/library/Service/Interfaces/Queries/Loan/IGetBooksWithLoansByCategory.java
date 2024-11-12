package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Loan;

import java.util.List;

// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Loan;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.LoanEntity;

public interface IGetBooksWithLoansByCategory {
    
    public List<LoanEntity> getBooksByCategoryWithLoans(String name) throws Exception;
}
