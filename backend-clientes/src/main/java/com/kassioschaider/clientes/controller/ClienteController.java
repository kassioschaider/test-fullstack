package com.kassioschaider.clientes.controller;

import com.kassioschaider.clientes.model.Cliente;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ClienteController {

    @GetMapping("/clientes")
    public String list() {
        return "HelloWorld";
    }
}
