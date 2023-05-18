package com.alga.algaspring.exceptions;

//gera a mensaem de erro
public class NegocioException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;

    public NegocioException (String message){
        super(message);
    }
}
