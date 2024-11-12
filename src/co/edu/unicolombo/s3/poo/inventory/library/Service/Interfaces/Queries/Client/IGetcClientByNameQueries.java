
package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Client;

// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Client;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.ClientEntity;

/**
 *
 * @author Juan
 */
public interface IGetcClientByNameQueries {
    
    public ClientEntity getClientByName(String name) throws Exception;
}
