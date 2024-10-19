
package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Loan;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Client;
import java.util.List;

/**
 *
 * @author Juan
 */
public interface IGetListClientsWithLoan {
    
    public List<Client> getClientsWithLoan() throws Exception;
}
