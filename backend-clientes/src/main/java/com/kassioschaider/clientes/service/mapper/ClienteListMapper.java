package com.kassioschaider.clientes.service.mapper;

import com.kassioschaider.clientes.model.Cliente;
import com.kassioschaider.clientes.service.dto.ClienteListDTO;
import org.mapstruct.Mapper;

/**
 * Classe de Mapper ClienteListMapper
 */
@Mapper(componentModel = "spring")
public interface ClienteListMapper extends EntityMapper<ClienteListDTO, Cliente> {}
