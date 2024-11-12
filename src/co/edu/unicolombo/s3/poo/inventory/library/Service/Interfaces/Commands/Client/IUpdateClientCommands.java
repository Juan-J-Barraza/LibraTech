
package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Commands.Client;

// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Client;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.ClientEntity;

/**
 *
 * @author Juan
 */
public interface IUpdateClientCommands {
    
    public void updateClient(ClientEntity client) throws Exception;
}
