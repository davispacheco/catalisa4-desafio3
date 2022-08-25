package com.modulo5.catalisa4desafio3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.modulo5.catalisa4desafio3.model.enums.Status;
import com.modulo5.catalisa4desafio3.model.enums.Tipo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contasapagar")
public class ContasAPagarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String nome;

    @Column(length = 10, nullable = false)
    private double valor;

    @Column(length = 20, nullable = false)
    private Tipo tipo;

    @Column(length = 20, nullable = false)
    private LocalDate dataDeVencimento;

    @Column(length = 20)
    private LocalDateTime dataDePagamento;

    @Column(length = 20)
    private Status status;
}
