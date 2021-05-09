package com.kassioschaider.clientes.service;

import com.kassioschaider.clientes.service.dto.CategoriaDTO;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    List<CategoriaDTO> list();

    CategoriaDTO create(CategoriaDTO categoriaDTO);

    CategoriaDTO update(CategoriaDTO categoriaDTO);

    Optional<CategoriaDTO> getById(Long id);

    void deleteById(Long id);
}
