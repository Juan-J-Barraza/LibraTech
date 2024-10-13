package co.edu.unicolombo.s3.poo.inventory.library.Service;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Client;
import co.edu.unicolombo.s3.poo.inventory.library.Domain.Db;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Juan
 */
public class ClientService {

    private final Db db = Db.getInstance();

    public void addClient(Client client) throws Exception {
        if (client != null) {
            db.getListClients().add(client);
        }
        throw new Exception("The client can not created");
    }

    public List<Client> getListClients() throws Exception {
        if (db.getListClients() == null || db.getListClients().isEmpty()) {
            throw new Exception();
        }
        return db.getListClients();
    }

    public void updateClient(int idClient, Client newClient)
            throws Exception {
        if (idClient == 0 && newClient == null) {
            throw new Exception("the client is null or id invalid");
        }
        var indexClient = db.getIndexClientById(idClient);
        db.getListClients().set(indexClient, newClient);
    }

    public void deleteClient(Client client) {
        if (client != null) {
            var indexClient = db.getIndexClientById(client.getID());
            db.getListClients().remove(indexClient);
        }
    }

    public Client getClient(String name)
            throws Exception {
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

}
