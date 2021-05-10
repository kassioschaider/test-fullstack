package com.kassioschaider.clientes.service.mapper;

import com.kassioschaider.clientes.model.Cliente;
import com.kassioschaider.clientes.model.Email;
import com.kassioschaider.clientes.service.dto.ClienteDTO;
import com.kassioschaider.clientes.service.dto.EmailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Classe de Mapper ClienteMapper
 */
@Mapper(componentModel = "spring")
public interface ClienteMapper extends EntityMapper<ClienteDTO, Cliente> {}
