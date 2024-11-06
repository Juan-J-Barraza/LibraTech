
package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Commands.Client;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Client;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Repositories.ClientRepository;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Commands.Client.ICreateClientCommands;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.IClientRepository;

/**
 *
 * @author Jose
 */
public class CreateClientCommmands implements ICreateClientCommands {

    private IClientRepository clientRepository;

    public CreateClientCommmands(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void createClient(Client client) throws Exception {
        clientRepository.addClient(client);
    }

}
