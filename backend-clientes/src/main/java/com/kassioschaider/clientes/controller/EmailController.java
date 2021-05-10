package com.kassioschaider.clientes.controller;

import com.kassioschaider.clientes.service.EmailService;
import com.kassioschaider.clientes.service.dto.EmailDTO;
import com.kassioschaider.clientes.util.ResponseUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class EmailController {

    @Autowired
    private final EmailService emailService;

    @GetMapping("emails")
    public List<EmailDTO> list() {
        return emailService.list();
    }

    @Transactional
    @PostMapping("emails")
    public ResponseEntity<EmailDTO> create(@RequestBody EmailDTO emailDTO, UriComponentsBuilder uriBuilder) {
        EmailDTO result = emailService.create(emailDTO);
        return ResponseEntity.created(uriBuilder.path("/emails/{id}")
                .buildAndExpand(result.getId()).toUri())
                .body(result);
    }

    @Transactional
    @PutMapping("emails")
    public ResponseEntity<EmailDTO> update(@RequestBody EmailDTO emailDTO, UriComponentsBuilder uriBuilder) {
        EmailDTO result = emailService.update(emailDTO);
        return ResponseEntity.created(uriBuilder.path("/emails")
                .buildAndExpand(result.getId()).toUri())
                .body(result);
    }

    @GetMapping("emails/{id}")
    public ResponseEntity<EmailDTO> getById(@PathVariable Long id) {
        return ResponseUtil.wrapOrNotFound(emailService.getById(id));
    }

    @Transactional
    @DeleteMapping("emails/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        emailService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
