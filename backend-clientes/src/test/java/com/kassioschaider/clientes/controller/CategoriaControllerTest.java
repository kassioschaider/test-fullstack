package com.kassioschaider.clientes.controller;

import com.kassioschaider.clientes.model.Categoria;
import com.kassioschaider.clientes.repository.CategoriaRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CategoriaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Before
    public void init() {
        Categoria categoria = new Categoria(null, "Categoria Test");
        categoriaRepository.save(categoria);
    }

    @Test
    public void list() throws Exception {
        URI uri = new URI("/api/categorias");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        Assertions.assertEquals("[{\"id\":2,\"nome\":\"Categoria Test\"},{\"id\":3,\"nome\":\"Categoria Test\"},{\"id\":4,\"nome\":\"Categoria Test\"},{\"id\":5,\"nome\":\"Categoria Test Alterada\"},{\"id\":6,\"nome\":\"Categoria Test\"},{\"id\":7,\"nome\":\"Categoria Test\"}]", content);
    }

    @Test
    public void create() throws Exception {
        URI uri = new URI("/api/categorias");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content("{\"nome\": \"Categoria Test\"}"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(201))
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        Assertions.assertEquals("{\"id\":2,\"nome\":\"Categoria Test\"}", content);
    }

    @Test
    public void update() throws Exception {
        URI uri = new URI("/api/categorias");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content("{\"id\":1,\"nome\":\"Categoria Test Alterada\"}"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(201))
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        Assertions.assertEquals("{\"id\":5,\"nome\":\"Categoria Test Alterada\"}", content);
    }

    @Test
    public void getById() throws Exception {
        URI uri = new URI("/api/categorias/5");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        Assertions.assertEquals("{\"id\":5,\"nome\":\"Categoria Test Alterada\"}", content);
    }

    @Test
    public void delete() throws Exception {
        URI uri = new URI("/api/categorias/1");

        mockMvc.perform(MockMvcRequestBuilders.delete(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();
    }
}