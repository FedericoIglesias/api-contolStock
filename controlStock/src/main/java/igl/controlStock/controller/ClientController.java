package igl.controlStock.controller;

import igl.controlStock.model.Client;
import igl.controlStock.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    ClientService serviClient;

    @PostMapping("/clients/create")
    public ResponseEntity<String> createClient(@RequestBody Client client) {
        serviClient.createClient(client);
        return new ResponseEntity<>("Success to create client", HttpStatus.CREATED);
    }

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getListClient() {
        return new ResponseEntity<>(serviClient.getListClient(), HttpStatus.OK);
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Long id) {
        return new ResponseEntity<>(serviClient.getClient(id), HttpStatus.OK);
    }

    @DeleteMapping("/clients/delete/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id) {
        serviClient.deleteClient(id);
        return new ResponseEntity<>("Success to delete Client", HttpStatus.OK);
    }

    @PutMapping("/clients/edit/{id}")
    public ResponseEntity<Client> editClient(@RequestBody Client client, @PathVariable Long id) {
        serviClient.editClient(client);
        return new ResponseEntity<>(serviClient.getClient(id), HttpStatus.OK);
    }
}
