
package co.edu.unicolombo.s3.poo.inventory.library.Service.Controller.Queries.Loan;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Client;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Repositories.LoanRepository;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Loan.IGetClientLoanQueries;

/**
 *
 * @author Juan
 */
public class GetClientFromLoanQueries implements IGetClientLoanQueries {

    private LoanRepository loanRepository;

    public GetClientFromLoanQueries(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public Client getClientLoan(int idClient) throws Exception {
        return loanRepository.getClientFromLoan(idClient);
    }

    
}
