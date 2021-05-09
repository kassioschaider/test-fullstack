package com.kassioschaider.clientes.controller;

import com.kassioschaider.clientes.service.CategoriaService;
import com.kassioschaider.clientes.service.dto.CategoriaDTO;
import com.kassioschaider.clientes.util.ResponseUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class CategoriaController {

    @Autowired
    private final CategoriaService categoriaService;

    @GetMapping("categorias")
    public List<CategoriaDTO> list() {
        return categoriaService.list();
    }

    @Transactional
    @PostMapping("categorias")
    public ResponseEntity<CategoriaDTO> create(@RequestBody CategoriaDTO categoriaDTO, UriComponentsBuilder uriBuilder) {
        CategoriaDTO result = categoriaService.create(categoriaDTO);
        return ResponseEntity.created(uriBuilder.path("/categorias/{id}")
            .buildAndExpand(result.getId()).toUri())
            .body(result);
    }

    @Transactional
    @PutMapping("categorias")
    public ResponseEntity<CategoriaDTO> update(@RequestBody CategoriaDTO categoriaDTO, UriComponentsBuilder uriBuilder) {
        CategoriaDTO result = categoriaService.update(categoriaDTO);
        return ResponseEntity.created(uriBuilder.path("/categorias")
                .buildAndExpand(result.getId()).toUri())
                .body(result);
    }

    @GetMapping("categorias/{id}")
    public ResponseEntity<CategoriaDTO> getById(@PathVariable Long id) {
        return ResponseUtil.wrapOrNotFound(categoriaService.getById(id));
    }

    @Transactional
    @DeleteMapping("categorias/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        categoriaService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
