package com.alga.algaspring.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alga.algaspring.model.ClientModel;

public interface ClientRepository extends JpaRepository <ClientModel, Long>{
    
    //se quiser fazer um customizado:
    List<ClientModel> findByName(String name);

    //utilizado no Service para ver se o email é repetido ou não
    Optional<ClientModel> findByEmail(String email);
}
