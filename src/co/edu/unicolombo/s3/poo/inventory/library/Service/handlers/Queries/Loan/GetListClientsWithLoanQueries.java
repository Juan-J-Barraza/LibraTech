
package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Queries.Loan;

import java.util.List;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Client;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Repositories.LoanRepository;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Loan.IGetListClientsWithLoan;

/**
 *
 * @author Juan
 */
public class GetListClientsWithLoanQueries implements IGetListClientsWithLoan{
    
    private LoanRepository loanRepository;

    public GetListClientsWithLoanQueries(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public List<Client> getClientsWithLoan() throws Exception {
        return loanRepository.getListClientsWithLoan();
    }

}
