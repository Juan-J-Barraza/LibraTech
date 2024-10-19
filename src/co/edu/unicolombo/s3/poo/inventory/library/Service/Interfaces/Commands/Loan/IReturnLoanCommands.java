
package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Commands.Loan;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Loan;

/**
 *
 * @author Juan
 */
public interface IReturnLoanCommands {
    
    public void returnLoan(Loan loan) throws Exception;
}
