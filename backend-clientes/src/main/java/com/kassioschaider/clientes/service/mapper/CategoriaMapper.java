package com.kassioschaider.clientes.service.mapper;

import com.kassioschaider.clientes.model.Categoria;
import com.kassioschaider.clientes.service.dto.CategoriaDTO;
import org.mapstruct.Mapper;

/**
 * Classe de Mapper CategoriaMapper
 */
@Mapper(componentModel = "spring")
public interface CategoriaMapper extends EntityMapper<CategoriaDTO, Categoria> {}
