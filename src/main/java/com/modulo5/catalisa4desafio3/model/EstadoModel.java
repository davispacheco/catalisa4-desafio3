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
@Table(name = "estados")
public class EstadoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String uf;

    private String nomeEstado;

    @JsonIgnore
    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<CidadeModel> cidades = new ArrayList<>();

    public EstadoModel(String uf, String nomeEstado) {
        this.uf = uf;
        this.nomeEstado = nomeEstado;
    }
}
