package com.alga.algaspring.controller;

import java.util.List;

//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alga.algaspring.model.ClientModel;
import com.alga.algaspring.repositories.ClientRepository;

@RestController
@RequestMapping
public class ClientController {

    //@PersistenceContext //injeta um entinty manager
    //private EntityManager manager;
    
    @Autowired
    private ClientRepository clientRepository;


    @GetMapping("/client")
    public List<ClientModel> hello(){
        //return manager.createQuery("from ClientModel", ClientModel.class).getResultList();
        return clientRepository.findAll();    
    }
}
