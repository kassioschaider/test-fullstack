package com.kassioschaider.clientes.service.impl;

import com.kassioschaider.clientes.model.Email;
import com.kassioschaider.clientes.repository.EmailRepository;
import com.kassioschaider.clientes.service.EmailService;
import com.kassioschaider.clientes.service.dto.EmailDTO;
import com.kassioschaider.clientes.service.mapper.EmailMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmailServiceImpl implements EmailService {

    @Autowired
    private final EmailRepository emailRepository;

    @Autowired
    private final EmailMapper emailMapper;

    @Override
    public List<EmailDTO> list() {
        return emailMapper.toDto(emailRepository.findAll());
    }

    @Override
    public EmailDTO create(EmailDTO emailDTO) {
        Email email = emailMapper.toEntity(emailDTO);
        return emailMapper.toDto(emailRepository.save(email));
    }

    @Override
    public EmailDTO update(EmailDTO emailDTO) {
        Email email = emailMapper.toEntity(emailDTO);
        return emailMapper.toDto(emailRepository.save(email));
    }

    @Override
    public Optional<EmailDTO> getById(Long id) {
        return emailRepository.findById(id).map(emailMapper::toDto);
    }

    @Override
    public void deleteById(Long id) {
        emailRepository.deleteById(id);
    }
}
