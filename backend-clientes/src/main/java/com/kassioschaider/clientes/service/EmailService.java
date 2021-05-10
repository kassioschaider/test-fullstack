package com.kassioschaider.clientes.service;

import com.kassioschaider.clientes.service.dto.EmailDTO;
import com.kassioschaider.clientes.service.dto.EmailListDTO;

import java.util.List;
import java.util.Optional;

public interface EmailService {

    List<EmailListDTO> list();

    EmailDTO create(EmailDTO emailDTO);

    EmailDTO update(EmailDTO emailDTO);

    Optional<EmailDTO> getById(Long id);

    void deleteById(Long id);
}
