
package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Queries.Loan;

import java.util.List;

// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Client;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.ClientEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Loan.IGetListClientsWithLoan;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.ILoanRepository;

/**
 *
 * @author Juan
 */
public class GetListClientsWithLoanQueries implements IGetListClientsWithLoan{
    
    private ILoanRepository loanRepository;

    public GetListClientsWithLoanQueries(ILoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public List<ClientEntity> getClientsWithLoan() throws Exception {
        return loanRepository.getListClientsWithLoan();
    }

}
