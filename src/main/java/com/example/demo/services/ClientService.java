package com.example.demo.services;

import com.example.demo.entities.Client;
import com.example.demo.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public List<Client> findAll() {
        return repository.findAll();
    }

    public Client findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found: " + id));
    }

    public Client create(Client client) {
        return repository.save(client);
    }

    public Client update(Long id, Client client) {
        Client existing = findById(id);

        existing.setName(client.getName());
        existing.setEmail(client.getEmail());
        existing.setCpf(client.getCpf());

        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}