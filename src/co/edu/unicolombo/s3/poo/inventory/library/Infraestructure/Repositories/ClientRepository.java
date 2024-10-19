package co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Repositories;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Client;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.DB;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.IClientRepository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Jose
 */
public class ClientRepository implements IClientRepository {

    private final DB db = DB.getInstance();

    @Override
    public void addClient(Client client) throws Exception {
        if (client == null) {
            throw new Exception("The client can not created");
        }
        db.getListClients().add(client);
    }

    @Override
    public List<Client> getListClients() throws Exception {
        if (db.getListClients() == null || db.getListClients().isEmpty()) {
            throw new Exception();
        }
        return db.getListClients();
    }

    @Override
    public Client getClientByName(String name) throws Exception {
        if (name == null) {
            throw new Exception("name is null");
        }
        Optional<Client> firstClient = db.getListClients()
                .stream()
                .filter(cl -> cl.getName().equalsIgnoreCase(name))
                .findFirst();
        if (!firstClient.isPresent()) {
            throw new Exception("client not found");
        }
        return firstClient.get();
    }

    @Override
    public void updateClient(Client newClient) throws Exception {
        if (newClient == null) {
            throw new Exception("the client is null or id invalid");
        }
        var indexClient = db.getIndexClientById(newClient.getID());
        db.getListClients().set(indexClient, newClient);
    }

    @Override
    public void deleteClient(Client client) {
        if (client != null) {
            var indexClient = db.getIndexClientById(client.getID());
            db.getListClients().remove(indexClient);
        }
    }

    @Override
    public Client getClientByIDClient(int IDClient) throws Exception {
        if (IDClient == 0) {
            throw new Exception("clientId do not exist");
        }

        var indexClient = db.getIndexClientById(IDClient);
        return db.getListClients().get(indexClient);
    }

}
