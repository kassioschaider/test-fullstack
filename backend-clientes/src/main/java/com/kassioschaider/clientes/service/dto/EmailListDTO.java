package com.kassioschaider.clientes.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmailListDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nomeCategoria;
    private String nome;
    private String email;
    private Long idCliente;
}
