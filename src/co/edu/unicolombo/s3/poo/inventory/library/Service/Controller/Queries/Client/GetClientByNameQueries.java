
package co.edu.unicolombo.s3.poo.inventory.library.Service.Controller.Queries.Client;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Client;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Repositories.ClientRepository;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Client.IGetcClientByNameQueries;

/**
 *
 * @author Jean
 */
public class GetClientByNameQueries implements IGetcClientByNameQueries {

    private ClientRepository clientRepository;

    public GetClientByNameQueries(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client getClientByName(String name) throws Exception {
        return clientRepository.getClientByName(name);
    }

}
