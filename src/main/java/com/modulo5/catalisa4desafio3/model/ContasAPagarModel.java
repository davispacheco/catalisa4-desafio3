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
@Table(name = "contas_a_pagar")
public class ContasAPagarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String nome;

    private double valor;

    private Tipo tipo;

    private LocalDate dataDeVencimento;

    private LocalDateTime dataDePagamento;

    private Status status;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "codigo")
    private UsuarioModel usuario;

    public ContasAPagarModel(String nome, double valor, Tipo tipo, LocalDate dataDeVencimento, LocalDateTime dataDePagamento, Status status, UsuarioModel usuario) {
        this.nome = nome;
        this.valor = valor;
        this.tipo = tipo;
        this.dataDeVencimento = dataDeVencimento;
        this.dataDePagamento = dataDePagamento;
        this.status = status;
        this.usuario = usuario;
    }
}
