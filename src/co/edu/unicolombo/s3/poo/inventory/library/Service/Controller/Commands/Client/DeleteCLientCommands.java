
package co.edu.unicolombo.s3.poo.inventory.library.Service.Controller.Commands.Client;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Client;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Repositories.ClientRepository;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Commands.Client.IDeleteClientCommands;

/**
 *
 * @author Juan
 */
public class DeleteCLientCommands implements IDeleteClientCommands {
    private ClientRepository clientRepository;

    public DeleteCLientCommands(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void deleteClient(Client client) throws Exception {
      clientRepository.deleteClient(client);
    }

    
}
