package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Queries.Loan;

import java.util.List;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Loan;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Loan.IGetBooksWithLoansByCategory;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.ILoanRepository;

public class GetBooksWithLoanByCateg implements IGetBooksWithLoansByCategory {
    
    private ILoanRepository repository;

    public GetBooksWithLoanByCateg(ILoanRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Loan> getBooksByCategoryWithLoans(String name) throws Exception{
        return repository.getBooksWithLoansByCategory(name);
    }

    

    
}
