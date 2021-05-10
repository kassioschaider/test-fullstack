package com.kassioschaider.clientes.service.mapper;

import com.kassioschaider.clientes.model.Cliente;
import com.kassioschaider.clientes.service.dto.ClienteDTO;
import org.mapstruct.Mapper;

/**
 * Classe de Mapper ClienteMapper
 */
@Mapper(componentModel = "spring")
public interface ClienteMapper extends EntityMapper<ClienteDTO, Cliente> {}
