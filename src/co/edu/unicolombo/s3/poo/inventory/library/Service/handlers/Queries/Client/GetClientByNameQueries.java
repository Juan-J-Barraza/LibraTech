
package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Queries.Client;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Client;

import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Client.IGetcClientByNameQueries;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.IClientRepository;

/**
 *
 * @author Jean
 */
public class GetClientByNameQueries implements IGetcClientByNameQueries {

    private IClientRepository clientRepository;

    public GetClientByNameQueries(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client getClientByName(String name) throws Exception {
        return clientRepository.getClientByName(name);
    }

}
