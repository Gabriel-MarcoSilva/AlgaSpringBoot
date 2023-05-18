package com.alga.algaspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alga.algaspring.model.ClientModel;

public interface ClientRepository extends JpaRepository <ClientModel, Long>{
    
}
