package com.alga.algaspring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ClientController {
    
    @GetMapping("/client")
    public List<String> hello(){
        return null;
    }
}
