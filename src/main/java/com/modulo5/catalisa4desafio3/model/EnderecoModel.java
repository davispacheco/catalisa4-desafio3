package com.modulo5.catalisa4desafio3.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "enderecos")
public class EnderecoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(length = 30, nullable = false)
    private String logradouro;

    @Column(length = 20, nullable = false)
    private String bairro;

    @Column(length = 8, nullable = false)
    private String cep;

    @Column(length = 40, nullable = false)
    private String pontoReferencia;

    @ManyToOne
    @JoinColumn(name = "cidade_id", referencedColumnName = "codigo")
    private CidadeModel cidade;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "codigo")
    private UsuarioModel usuario;

    public EnderecoModel(String logradouro, String bairro, String cep, String pontoReferencia, CidadeModel cidade, UsuarioModel usuario) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
        this.pontoReferencia = pontoReferencia;
        this.cidade = cidade;
        this.usuario = usuario;
    }
}
