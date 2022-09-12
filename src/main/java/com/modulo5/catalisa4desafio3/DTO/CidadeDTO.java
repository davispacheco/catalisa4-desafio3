package com.modulo5.catalisa4desafio3.DTO;

import com.modulo5.catalisa4desafio3.model.CidadeModel;
import com.modulo5.catalisa4desafio3.model.EstadoModel;
import lombok.Getter;

@Getter
public class CidadeDTO {
    private String nomeCidade;

    private EstadoModel estado;

    public CidadeModel converterParaObjeto() {
        return new CidadeModel(nomeCidade, estado);
    }
}
