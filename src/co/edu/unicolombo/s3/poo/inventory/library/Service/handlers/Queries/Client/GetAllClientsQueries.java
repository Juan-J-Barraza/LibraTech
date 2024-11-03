
package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Queries.Client;

import java.util.List;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Client;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Repositories.ClientRepository;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Client.IGetListClientQueries;

/**
 *
 * @author Jean
 */
public class GetAllClientsQueries implements IGetListClientQueries {

    private ClientRepository clientRepository;

    public GetAllClientsQueries(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getListClients() throws Exception {
        return clientRepository.getListClients();
    }

}
