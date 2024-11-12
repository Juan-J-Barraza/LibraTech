
package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Commands.Loan;

// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Loan;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.LoanEntity;

/**
 *
 * @author Juan
 */
public interface IReturnLoanCommands {
    
    public void returnLoan(LoanEntity loan) throws Exception;
}
