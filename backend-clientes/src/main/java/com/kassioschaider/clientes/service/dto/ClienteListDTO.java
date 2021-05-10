package com.kassioschaider.clientes.service.dto;

import com.kassioschaider.clientes.model.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteListDTO implements Serializable {

    private Long id;
    private String inscricao;
    private String nome;
    private String apelido;
    private Status status = Status.ATIVADO;
}
