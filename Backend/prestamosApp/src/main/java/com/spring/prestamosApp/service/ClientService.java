package com.spring.prestamosApp.service;

import com.spring.prestamosApp.exception.ClientNotFoundException;
import com.spring.prestamosApp.model.Client;
import com.spring.prestamosApp.repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepo clientRepo;

    @Autowired
    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public Client addClient(Client client) {
        return clientRepo.save(client);
    }

    public List<Client> findAllClients() {
        return clientRepo.findAll();
    }

    public Client updateClient(Client client) {
        return clientRepo.save(client);
    }

    public Client findClientById(Long id) {
        return clientRepo.findById(id)
                .orElseThrow(()->new ClientNotFoundException("Client with id: " + id + "was not found"));
    }

    public void deleteClient(Long id) {
        clientRepo.deleteById(id);
    }

}
