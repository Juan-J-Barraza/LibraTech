
package co.edu.unicolombo.s3.poo.inventory.library.Service.Controller.Commands.Client;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Client;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Repositories.ClientRepository;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Commands.Client.IUpdateClientCommands;

/**
 *
 * @author Juan
 */
public class UpdatecClientCommands implements IUpdateClientCommands {

    private ClientRepository clientRepository;

    public UpdatecClientCommands(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void updateClient(Client client) throws Exception {
        clientRepository.updateClient(client);
    }

}
