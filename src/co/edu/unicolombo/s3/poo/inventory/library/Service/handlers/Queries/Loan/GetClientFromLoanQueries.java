
package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Queries.Loan;

// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Client;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.ClientEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Loan.IGetClientLoanQueries;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.ILoanRepository;

/**
 *
 * @author Juan
 */
public class GetClientFromLoanQueries implements IGetClientLoanQueries {

    private ILoanRepository loanRepository;

    public GetClientFromLoanQueries(ILoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public ClientEntity getClientLoan(int idClient) throws Exception {
        return loanRepository.getClientFromLoan(idClient);
    }

    
}
