
package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Commands.Loan;

// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Loan;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.LoanEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Commands.Loan.IReturnLoanCommands;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.ILoanRepository;

/**
 *
 * @author Juan
 */
public class ReturnLoanCommandsController implements IReturnLoanCommands {

    private ILoanRepository loanRepository;

    public ReturnLoanCommandsController(ILoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public void returnLoan(LoanEntity loan) throws Exception {
        loanRepository.returnBook(loan);
    }

}
