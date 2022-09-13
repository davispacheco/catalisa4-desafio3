package com.modulo5.catalisa4desafio3.DTO;

import com.modulo5.catalisa4desafio3.model.EstadoModel;

public class EstadoDTO {
    private String uf;

    private String nomeEstado;

    public EstadoModel converterParaObjeto() {
        return new EstadoModel(uf, nomeEstado);
    }
}
