
package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Commands.Loan;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Loan;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Repositories.LoanRepository;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Commands.Loan.IAddLoanCommands;

/**
 *
 * @author Juan
 */
public class CreateLoanCommandsController implements IAddLoanCommands {
   
    private LoanRepository loanrRepository;

    public CreateLoanCommandsController(LoanRepository loanRepository) {
        this.loanrRepository = loanRepository;
    }


    @Override
    public void addLoan(Loan loan) throws Exception {
        loanrRepository.addloanBook(loan);
    }

}
