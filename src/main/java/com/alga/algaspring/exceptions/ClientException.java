package com.alga.algaspring.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


//tratamentos
@ControllerAdvice
public class ClientException extends ResponseEntityExceptionHandler {
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {

        Problema problema = new Problema();

        List<Problema.Campo> campos = new ArrayList<>();

        for ( ObjectError error: ex.getBindingResult().getAllErrors()){ //pega todos os erros que apareceram
            String name = ((FieldError) error).getField();
            String message = error.getDefaultMessage();

            campos.add(new Problema.Campo(name, message));
        }

        problema.setTitulo("Campo inválido, preencha corretamente");
        problema.setDatahora(LocalDateTime.now());
        problema.setStatus(status.value());
        problema.setCampo(campos);

        return handleExceptionInternal(ex, problema, headers, status, request);
    }
}
