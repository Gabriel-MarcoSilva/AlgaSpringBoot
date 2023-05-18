package com.alga.algaspring.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(Include.NON_NULL) //só vai aparecer no JSON itens não nulos
@Getter
@Setter
public class Problema {
    
    private Integer status;
    private LocalDateTime datahora;
    private String titulo;

    private List<Campo> campo; //mostrar os campos que foram preenchidos incorretamente

    @AllArgsConstructor
    @Getter
    public static class Campo{
        private String name;
        private String message;
    }
}
