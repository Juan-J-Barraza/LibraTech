
package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Queries.Loan;

import java.util.List;

// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Loan;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.LoanEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Loan.IGetLoansQueries;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.ILoanRepository;

/**
 *
 * @author Juan
 */
public class GetAllLoansQueries  implements IGetLoansQueries{
    
    private ILoanRepository loanRepository;

    public GetAllLoansQueries(ILoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public List<LoanEntity> getLoans() throws Exception {
        return loanRepository.getLoans();
    }

    
}
