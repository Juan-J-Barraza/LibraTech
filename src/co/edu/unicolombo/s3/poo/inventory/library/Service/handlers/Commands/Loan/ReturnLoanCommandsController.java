
package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Commands.Loan;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Loan;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Repositories.LoanRepository;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Commands.Loan.IReturnLoanCommands;

/**
 *
 * @author Juan
 */
public class ReturnLoanCommandsController implements IReturnLoanCommands {

    private LoanRepository loanRepository;

    public ReturnLoanCommandsController(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public void returnLoan(Loan loan) throws Exception {
        loanRepository.returnBook(loan);
    }

}
