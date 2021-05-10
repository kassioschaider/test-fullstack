package com.kassioschaider.clientes.controller;

import com.kassioschaider.clientes.model.Categoria;
import com.kassioschaider.clientes.model.Cliente;
import com.kassioschaider.clientes.repository.CategoriaRepository;
import com.kassioschaider.clientes.repository.ClienteRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClienteRepository clienteRepository;

    @Before
    public void init() {
//        Cliente cliente = new Cliente(null, "Categoria Test");
//        clienteRepository.save(cliente);
    }

    @Test
    public void list() {
    }

    @Test
    public void create() {
    }

    @Test
    public void update() {
    }

    @Test
    public void getById() {
    }

    @Test
    public void delete() {
    }
}