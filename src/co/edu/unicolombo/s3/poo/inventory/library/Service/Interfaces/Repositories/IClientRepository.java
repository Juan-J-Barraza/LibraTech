/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Client;
import java.util.List;

/**
 *
 * @author Juan
 */
public interface IClientRepository {

    public void addClient(Client client) throws Exception;

    public List<Client> getListClients() throws Exception;

    public Client getClientByName(String name) throws Exception;

    public void updateClient(Client newClient) throws Exception;

    public void deleteClient(Client client);
}
