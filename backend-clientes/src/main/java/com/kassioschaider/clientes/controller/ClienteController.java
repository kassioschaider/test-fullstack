package com.kassioschaider.clientes.controller;

import com.kassioschaider.clientes.service.ClienteService;
import com.kassioschaider.clientes.service.dto.ClienteDTO;
import com.kassioschaider.clientes.service.dto.ClienteListDTO;
import com.kassioschaider.clientes.util.ResponseUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ClienteController {

    @Autowired
    private final ClienteService clienteService;

    @GetMapping("clientes")
    public List<ClienteListDTO> list() {
        return clienteService.list();
    }

    @Transactional
    @PostMapping("clientes")
    public ResponseEntity<ClienteListDTO> create(@RequestBody ClienteListDTO clienteListDTO, UriComponentsBuilder uriBuilder) {
        ClienteListDTO result = clienteService.create(clienteListDTO);
        return ResponseEntity.created(uriBuilder.path("/clientes/{id}")
                .buildAndExpand(result.getId()).toUri())
                .body(result);
    }

    @Transactional
    @PutMapping("clientes")
    public ResponseEntity<ClienteDTO> update(@RequestBody ClienteDTO clienteDto, UriComponentsBuilder uriBuilder) {
        ClienteDTO result = clienteService.update(clienteDto);
        return ResponseEntity.created(uriBuilder.path("/clientes")
                .buildAndExpand(result.getId()).toUri())
                .body(result);
    }

    @GetMapping("clientes/{id}")
    public ResponseEntity<ClienteDTO> getById(@PathVariable Long id) {
        return ResponseUtil.wrapOrNotFound(clienteService.getById(id));
    }

    @Transactional
    @DeleteMapping("clientes/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        clienteService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
