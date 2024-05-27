package igl.controlStock.service;

import igl.controlStock.model.Client;
import igl.controlStock.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService{

    @Autowired
    IClientRepository repoClient;

    @Override
    public List<Client> getListClient() {

        return repoClient.findAll();
    }

    @Override
    public Client getClient(Long id) {

        return repoClient.findById(id).orElse(null);
    }

    @Override
    public void deleteClient(Long id) {
        repoClient.deleteById(id);
    }

    @Override
    public void createClient(Client client) {
        repoClient.save(client);
    }

    @Override
    public void editClient(Client client) {
        repoClient.save(client);
    }
}
