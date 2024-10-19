
package co.edu.unicolombo.s3.poo.inventory.library.Service.Controller.Queries.Loan;

import java.util.List;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Loan;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Repositories.LoanRepository;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Loan.IGetLoansQueries;

/**
 *
 * @author Juan
 */
public class GetAllLoansQueries  implements IGetLoansQueries{
    
    private LoanRepository loanRepository;

    public GetAllLoansQueries(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public List<Loan> getLoans() throws Exception {
        return loanRepository.getLoans();
    }

    
}
