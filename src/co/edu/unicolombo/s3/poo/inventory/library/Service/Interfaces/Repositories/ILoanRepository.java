
package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Client;
import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Loan;
import java.util.List;

/**
 *
 * @author Juan
 */
public interface ILoanRepository {

    public void addloanBook(Loan loan) throws Exception;

    public List<Loan> getLoans() throws Exception;
    
    public Client getClientFromLoan(int idClient) throws Exception;

    public void returnBook(Loan loan) throws Exception;

    public List<Client> getListClientsWithLoan() throws Exception;

}
