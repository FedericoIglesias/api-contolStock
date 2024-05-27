package igl.controlStock.service;

import igl.controlStock.model.Client;

import java.util.List;

public interface IClientService {

    List<Client> getListClient();

    Client getClient(Long id);

    void deleteClient(Long id);

    void createClient(Client client);

    void editClient(Client client);

}
