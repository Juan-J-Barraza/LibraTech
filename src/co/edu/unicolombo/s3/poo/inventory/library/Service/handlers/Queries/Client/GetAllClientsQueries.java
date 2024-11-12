
package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Queries.Client;

import java.util.List;

// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Client;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.ClientEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Client.IGetListClientQueries;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.IClientRepository;

/**
 *
 * @author Jean
 */
public class GetAllClientsQueries implements IGetListClientQueries {

    private IClientRepository clientRepository;

    public GetAllClientsQueries(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ClientEntity> getListClients() throws Exception {
        return clientRepository.getListClients();
    }

}
