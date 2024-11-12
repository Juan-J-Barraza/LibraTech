package co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Repositories;

import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Config.HibernateUtil;
// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Client;
// import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.DB;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.ClientEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.IClientRepository;
import java.util.List;
// import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Jose
 */
public class ClientRepository implements IClientRepository {
    private final SessionFactory sessionFactory;

    // private final DB db = DB.getInstance();

    public ClientRepository() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void addClient(ClientEntity client) throws Exception {
        if (client == null) {
            throw new Exception("The client can not created");
        }
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null && session.getTransaction().getStatus().canRollback()) {
                session.getTransaction().rollback();
            }
            throw e;
        } finally {
            session.close();
        }

    }

    @Override
    public List<ClientEntity> getListClients() throws Exception {
        Session session = sessionFactory.openSession();
        try {
            var clients = session.createQuery("FROM ClientEntity", ClientEntity.class).list();
            if (clients == null || clients.isEmpty()) {
                throw new Exception("clients not found");
            }
            return clients;
        } finally {
            session.close();
        }
    }

    @Override
    public ClientEntity getClientByName(String name) throws Exception {
        if (name == null) {
            throw new Exception("name is null");
        }

        Session session = sessionFactory.openSession();
        try {
            ClientEntity client = session.createQuery("FROM ClientEntity WHERE LOWER(name) = :name",
                    ClientEntity.class).setParameter("name", name.toLowerCase())
                    .uniqueResult();
            if (client == null) {
                throw new Exception("Client not found");
            }
            return client;
        } finally {
            session.close();
        }

    }

    @Override
    public void updateClient(ClientEntity newClient) throws Exception {
        if (newClient == null) {
            throw new Exception("the client is null or id invalid");
        }
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            ClientEntity clientNew = session.get(ClientEntity.class, newClient.getId());
            if (clientNew == null) {
                throw new Exception("Book not found");
            }
            clientNew.setName(newClient.getName());
            clientNew.setPhoneNumber(newClient.getPhoneNumber());
            clientNew.setAddress(newClient.getAddress());
            session.update(clientNew);
            session.getTransaction().commit();

        } catch (Exception e) {
            if (session.getTransaction() != null && session.getTransaction().getStatus().canRollback()) {
                session.getTransaction().rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteClient(ClientEntity client) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            ClientEntity clientDeelete = session.get(ClientEntity.class, client.getId());
            session.delete(clientDeelete);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public ClientEntity getClientByIDClient(int IDClient) throws Exception {
        if (IDClient == 0) {
            throw new Exception("clientId do not exist");
        }
        Session session = sessionFactory.openSession();
        try {
            ClientEntity clEntity = session.createQuery("FROM ClienEntity WHERE id = :id",
                    ClientEntity.class).setParameter("id", IDClient).uniqueResult();
            return clEntity;
        } finally {
            session.close();
        }
    }

}
