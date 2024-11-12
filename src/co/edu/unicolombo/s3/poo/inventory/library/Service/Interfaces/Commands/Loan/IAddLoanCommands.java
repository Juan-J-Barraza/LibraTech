
package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Commands.Loan;

import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.LoanEntity;

/**
 *
 * @author Juan
 */
public interface IAddLoanCommands {
    
    public void addLoan(LoanEntity loan) throws Exception;
}
