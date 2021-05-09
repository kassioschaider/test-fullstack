package com.kassioschaider.clientes.service.impl;

import com.kassioschaider.clientes.repository.ClienteRepository;
import com.kassioschaider.clientes.service.ClienteService;
import com.kassioschaider.clientes.service.dto.ClienteDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteDTO> list() {
        return null;
    }

    @Override
    public ClienteDTO create(ClienteDTO clienteDTO) {
        return null;
    }

    @Override
    public ClienteDTO update(ClienteDTO clienteDTO) {
        return null;
    }

    @Override
    public Optional<ClienteDTO> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {

    }
}
