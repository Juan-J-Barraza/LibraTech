
package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Commands.Client;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Client;

/**
 *
 * @author Juan
 */
public interface IUpdateClientCommands {
    
    public void updateClient(Client client) throws Exception;
}
