package com.kassioschaider.clientes.service.dto;

import com.kassioschaider.clientes.model.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String inscricao;
    private String nome;
    private String apelido;
    private Status status;
    private List<EmailDTO> emails;
}
