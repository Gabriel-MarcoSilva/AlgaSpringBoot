package com.alga.algaspring.controller;

import java.util.List;

import javax.validation.Valid;

//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alga.algaspring.model.ClientModel;
import com.alga.algaspring.repositories.ClientRepository;

@RestController
@RequestMapping
public class ClientController {

    // @PersistenceContext //injeta um entinty manager
    // private EntityManager manager;

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping(value = "/client")
    public List<ClientModel> hello() {
        // return manager.createQuery("from ClientModel",
        // ClientModel.class).getResultList();
        return clientRepository.findAll();
    }

    @GetMapping(value = "/client/{id}")
    public ClientModel findById(@PathVariable Long id) {
        return clientRepository.findById(id).get();
    }

    @PostMapping(value = "/client")
    public ClientModel create(@Valid @RequestBody ClientModel client) {
        return clientRepository.save(client);
    }

    @PutMapping(value = "/client/{id}")
    public ResponseEntity<ClientModel> update(@Valid @RequestBody ClientModel client, @PathVariable Long id) {

        if (clientRepository.existsById(id)) {
            client.setId(id);
            return ResponseEntity.ok(clientRepository.save(client));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/client/{id}")
    public ClientModel delete(@PathVariable Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
        }

        return null;
    }
}
