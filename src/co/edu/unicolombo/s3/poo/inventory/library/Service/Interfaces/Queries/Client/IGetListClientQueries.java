
package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Client;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Client;
import java.util.List;

/**
 *
 * @author Juan
 */
public interface IGetListClientQueries {
    
    public List<Client> getListClients() throws Exception;
}
