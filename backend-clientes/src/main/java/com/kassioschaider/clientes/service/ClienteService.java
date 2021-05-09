package com.kassioschaider.clientes.service;

import com.kassioschaider.clientes.service.dto.ClienteDTO;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<ClienteDTO> list();

    ClienteDTO create(ClienteDTO clienteDTO);

    ClienteDTO update(ClienteDTO clienteDTO);

    Optional<ClienteDTO> getById(Long id);

    void deleteById(Long id);
}
