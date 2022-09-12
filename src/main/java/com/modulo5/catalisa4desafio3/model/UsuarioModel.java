package com.modulo5.catalisa4desafio3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(length = 20, nullable = false)
    private String nomeUsuario;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(length = 40, nullable = false)
    private String email;

    @Column(length = 11, nullable = false)
    private String cpf;
}
