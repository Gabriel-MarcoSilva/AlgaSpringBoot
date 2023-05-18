package com.alga.algaspring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alga.algaspring.exceptions.NegocioException;
import com.alga.algaspring.model.ClientModel;
import com.alga.algaspring.repositories.ClientRepository;

@Service
public class CatalogoDomainServices {
    
    @Autowired
    private ClientRepository clientRepository;

    //metodos para salvar e atualizar clientes
    //são usados para criar regras na hora de cadastrar/deletar algo, logo devem ficar no lugar do clientRepository do Cotroller

    @Transactional
    public ClientModel salvar(ClientModel client){

        //para ver se são cadastrados clientes com o mesmo email
        boolean emailEmUso = clientRepository.findByEmail(client.getEmail())
                                    .stream()
                                    .anyMatch(clientExist -> !clientExist.equals(client));
        
        if(emailEmUso){
            throw new NegocioException("email já cadastrado");
        }
        return clientRepository.save(client);
    }

    @Transactional
    public void delete(Long id){
        clientRepository.deleteById(id);
    }

}
