
package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Commands.Loan;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Loan;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Commands.Loan.IAddLoanCommands;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.ILoanRepository;

/**
 *
 * @author Juan
 */
public class CreateLoanCommandsController implements IAddLoanCommands {
   
    private ILoanRepository loanrRepository;

    public CreateLoanCommandsController(ILoanRepository loanRepository) {
        this.loanrRepository = loanRepository;
    }


    @Override
    public void addLoan(Loan loan) throws Exception {
        loanrRepository.addloanBook(loan);
    }

}
