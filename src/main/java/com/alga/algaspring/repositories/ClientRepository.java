package com.alga.algaspring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alga.algaspring.model.ClientModel;

public interface ClientRepository extends JpaRepository <ClientModel, Long>{
    
    //se quiser fazer um customizado:
    List<ClientModel> findByName(String name);
}
