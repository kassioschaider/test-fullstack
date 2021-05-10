package com.kassioschaider.clientes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String inscricao;
    private String nome;
    private String apelido;
    private Status status;
    private String url;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.REMOVE)
    private List<Email> emails = new ArrayList<>();
}
