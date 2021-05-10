package com.kassioschaider.clientes.service.mapper;

import com.kassioschaider.clientes.model.Email;
import com.kassioschaider.clientes.service.dto.EmailListDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Classe de Mapper EmailListMapper
 */
@Mapper(componentModel = "spring")
public interface EmailListMapper extends EntityMapper<EmailListDTO, Email> {

    @Override
    @Mapping(source = "idCliente", target = "cliente.id")
    @Mapping(source = "nomeCategoria", target = "categoria.nome")
    Email toEntity(EmailListDTO dto);

    @Override
    @Mapping(source = "cliente.id", target = "idCliente")
    @Mapping(source = "categoria.nome", target = "nomeCategoria")
    EmailListDTO toDto(Email entity);

    @Override
    @Mapping(source = "idCliente", target = "cliente.id")
    @Mapping(source = "nomeCategoria", target = "categoria.nome")
    List<Email> toEntity(List<EmailListDTO> dtoList);

    @Override
    @Mapping(source = "cliente.id", target = "idCliente")
    @Mapping(source = "categoria.nome", target = "nomeCategoria")
    List<EmailListDTO> toDto(List<Email> entityList);
}
