package com.kassioschaider.clientes.service.impl;

import com.kassioschaider.clientes.model.Cliente;
import com.kassioschaider.clientes.repository.ClienteRepository;
import com.kassioschaider.clientes.service.ClienteService;
import com.kassioschaider.clientes.service.dto.ClienteDTO;
import com.kassioschaider.clientes.service.dto.ClienteListDTO;
import com.kassioschaider.clientes.service.mapper.ClienteListMapper;
import com.kassioschaider.clientes.service.mapper.ClienteMapper;
import com.kassioschaider.clientes.service.mapper.EmailMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private final ClienteRepository clienteRepository;

    @Autowired
    private final ClienteListMapper clienteListMapper;

    @Autowired
    private final ClienteMapper clienteMapper;

    @Autowired
    private final EmailMapper emailMapper;

    @Override
    public List<ClienteListDTO> list() {
        return clienteListMapper.toDto(clienteRepository.findAll());
    }

    @Override
    public ClienteDTO create(ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        return clienteMapper.toDto(clienteRepository.save(cliente));
    }

    @Override
    public ClienteDTO update(ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        return clienteMapper.toDto(clienteRepository.save(cliente));
    }

    @Override
    public Optional<ClienteDTO> getById(Long id) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);

        if(optionalCliente.isEmpty()) {
            return Optional.empty();
        }

        Cliente cliente = optionalCliente.get();
        ClienteDTO clienteDTO = clienteMapper.toDto(cliente);
        clienteDTO.setEmails(emailMapper.toDto(cliente.getEmails()));

        return Optional.of(clienteDTO);
    }

    @Override
    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
}
