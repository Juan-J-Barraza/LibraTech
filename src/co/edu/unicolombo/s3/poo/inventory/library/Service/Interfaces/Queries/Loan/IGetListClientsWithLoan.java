
package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Loan;

// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Client;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.ClientEntity;

import java.util.List;

/**
 *
 * @author Juan
 */
public interface IGetListClientsWithLoan {
    
    public List<ClientEntity> getClientsWithLoan() throws Exception;
}
