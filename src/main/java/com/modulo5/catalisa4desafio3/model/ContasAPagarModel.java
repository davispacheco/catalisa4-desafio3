package com.modulo5.catalisa4desafio3.model;

import com.modulo5.catalisa4desafio3.enumeration.Status;
import com.modulo5.catalisa4desafio3.enumeration.Tipo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "contasapagar")
public class ContasAPagarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

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

    public ContasAPagarModel(String nome, double valor, Tipo tipo, LocalDate dataDeVencimento, LocalDateTime dataDePagamento, Status status) {
        this.nome = nome;
        this.valor = valor;
        this.tipo = tipo;
        this.dataDeVencimento = dataDeVencimento;
        this.dataDePagamento = dataDePagamento;
        this.status = status;
    }
}
