package com.alga.algaspring.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
