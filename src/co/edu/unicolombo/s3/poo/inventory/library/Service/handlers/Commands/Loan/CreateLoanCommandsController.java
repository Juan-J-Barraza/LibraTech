
package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Commands.Loan;

import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.LoanEntity;
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
    public void addLoan(LoanEntity loan) throws Exception {
        loanrRepository.addloanBook(loan);
    }

}
