package com.modulo5.catalisa4desafio3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cidades")
public class CidadeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(length = 20, nullable = false)
    private String nomeCidade;

    @ManyToOne
    @JoinColumn(name = "estado_id", referencedColumnName = "codigo")
    private EstadoModel estado;

    @JsonIgnore
    @OneToMany(mappedBy = "cidade", cascade = CascadeType.ALL)
    private List<EnderecoModel> enderecos = new ArrayList<>();

    public CidadeModel(String nomeCidade, EstadoModel estado) {
        this.nomeCidade = nomeCidade;
        this.estado = estado;
    }
}
