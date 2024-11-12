
package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Commands.Client;

// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Client;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.ClientEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Repositories.ClientRepository;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Commands.Client.IDeleteClientCommands;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.IClientRepository;

/**
 *
 * @author Jose
 */
public class DeleteCLientCommands implements IDeleteClientCommands {
    private IClientRepository clientRepository;

    public DeleteCLientCommands(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void deleteClient(ClientEntity client) throws Exception {
      clientRepository.deleteClient(client);
    }

    
}
