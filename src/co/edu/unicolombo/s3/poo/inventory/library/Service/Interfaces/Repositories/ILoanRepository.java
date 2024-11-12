
package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories;

import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.BookEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.ClientEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.LoanEntity;

import java.util.List;

/**
 *
 * @author Juan
 */
public interface ILoanRepository {

    public void addloanBook(LoanEntity loan) throws Exception;

    public List<LoanEntity> getLoans() throws Exception;
    
    public ClientEntity getClientFromLoan(int idClient) throws Exception;

    public void returnBook(LoanEntity loan) throws Exception;

    public List<ClientEntity> getListClientsWithLoan() throws Exception;

    public LoanEntity findLoanByBook(BookEntity book) throws Exception;

    public List<LoanEntity> getBooksWithLoansByCategory(String name) throws Exception;

}
