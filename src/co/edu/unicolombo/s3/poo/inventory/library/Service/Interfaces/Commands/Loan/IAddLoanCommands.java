
package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Commands.Loan;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Loan;

/**
 *
 * @author Juan
 */
public interface IAddLoanCommands {
    
    public void addLoan(Loan loan) throws Exception;
}
