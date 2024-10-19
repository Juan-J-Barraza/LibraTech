
package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Client;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Client;

/**
 *
 * @author Juan
 */
public interface IGetcClientByNameQueries {
    
    public Client getClientByName(String name) throws Exception;
}
