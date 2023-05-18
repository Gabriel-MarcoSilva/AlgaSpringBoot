package com.alga.algaspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode //faz o troço de ver se o id é igual ou não
@Getter //gera os getters
@Setter //gera os setters
@Entity // transforma o model em entidade
@Table(name = "TB_CLIENT") //cria tabela no banco de dados
public class ClientModel {
    
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String name;
    @Column (name = "fone")
    private String telefone;
    
}
