package com.kassioschaider.clientes.service.impl;

import com.kassioschaider.clientes.model.Categoria;
import com.kassioschaider.clientes.repository.CategoriaRepository;
import com.kassioschaider.clientes.service.CategoriaService;
import com.kassioschaider.clientes.service.dto.CategoriaDTO;
import com.kassioschaider.clientes.service.mapper.CategoriaMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private final CategoriaRepository categoriaRepository;

    @Autowired
    private final CategoriaMapper categoriaMapper;

    @Override
    public List<CategoriaDTO> list() {
        return categoriaMapper.toDto(categoriaRepository.findAll());
    }

    @Override
    public CategoriaDTO create(CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaMapper.toEntity(categoriaDTO);
        return categoriaMapper.toDto(categoriaRepository.save(categoria));
    }

    @Override
    public CategoriaDTO update(CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaMapper.toEntity(categoriaDTO);
        return categoriaMapper.toDto(categoriaRepository.save(categoria));
    }

    @Override
    public Optional<CategoriaDTO> getById(Long id) {
        return categoriaRepository.findById(id).map(categoriaMapper::toDto);
    }

    @Override
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }
}
