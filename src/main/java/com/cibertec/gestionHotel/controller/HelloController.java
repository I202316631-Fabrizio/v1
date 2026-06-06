package com.cibertec.gestionHotel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String home() {
        return "¡Aplicación Spring Boot funcionando!";
    }
}

