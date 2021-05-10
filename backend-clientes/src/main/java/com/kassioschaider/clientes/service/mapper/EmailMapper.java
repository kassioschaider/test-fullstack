package com.kassioschaider.clientes.service.mapper;

import com.kassioschaider.clientes.model.Email;
import com.kassioschaider.clientes.service.dto.EmailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Classe de Mapper EmailMapper
 */
@Mapper(componentModel = "spring")
public interface EmailMapper extends EntityMapper<EmailDTO, Email> {

    @Override
    @Mapping(source = "idCliente", target = "cliente.id")
    @Mapping(source = "idCategoria", target = "categoria.id")
    Email toEntity(EmailDTO dto);

    @Override
    @Mapping(source = "cliente.id", target = "idCliente")
    @Mapping(source = "categoria.id", target = "idCategoria")
    EmailDTO toDto(Email entity);

    @Override
    @Mapping(source = "idCliente", target = "cliente.id")
    @Mapping(source = "idCategoria", target = "categoria.id")
    List<Email> toEntity(List<EmailDTO> dtoList);

    @Override
    @Mapping(source = "cliente.id", target = "idCliente")
    @Mapping(source = "categoria.id", target = "idCategoria")
    List<EmailDTO> toDto(List<Email> entityList);
}
