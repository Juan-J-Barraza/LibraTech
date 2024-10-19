
package co.edu.unicolombo.s3.poo.inventory.library.Service.Controller.Commands.Client;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Client;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Repositories.ClientRepository;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Commands.Client.ICreateClientCommands;

/**
 *
 * @author Juan
 */
public class CreateClientCommmands implements ICreateClientCommands {

    private ClientRepository clientRepository;

    public CreateClientCommmands(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void createClient(Client client) throws Exception {
        clientRepository.addClient(client);
    }

}
