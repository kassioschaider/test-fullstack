package com.kassioschaider.clientes.service;

import com.kassioschaider.clientes.service.dto.ClienteDTO;
import com.kassioschaider.clientes.service.dto.ClienteListDTO;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<ClienteListDTO> list();

    ClienteListDTO create(ClienteListDTO clienteListDTO);

    ClienteDTO update(ClienteDTO clienteDTO);

    Optional<ClienteDTO> getById(Long id);

    void deleteById(Long id);
}
