/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories;

// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Client;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.ClientEntity;

import java.util.List;

/**
 *
 * @author Juan
 */
public interface IClientRepository {

    public void addClient(ClientEntity client) throws Exception;

    public List<ClientEntity> getListClients() throws Exception;

    public ClientEntity getClientByName(String name) throws Exception;

    public void updateClient(ClientEntity newClient) throws Exception;

    public void deleteClient(ClientEntity client);

    public ClientEntity getClientByIDClient(int IDClient ) throws Exception;
}
