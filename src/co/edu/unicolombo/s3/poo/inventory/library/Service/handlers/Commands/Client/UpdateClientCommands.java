
package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Commands.Client;

// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Client;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.ClientEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Repositories.ClientRepository;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Commands.Client.IUpdateClientCommands;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.IClientRepository;

/**
 *
 * @author Jose
 */
public class UpdateClientCommands implements IUpdateClientCommands {

    private IClientRepository clientRepository;

    public UpdateClientCommands(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void updateClient(ClientEntity client) throws Exception {
        clientRepository.updateClient(client);
    }

}
