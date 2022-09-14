package com.modulo5.catalisa4desafio3.DTO;

import com.modulo5.catalisa4desafio3.model.CidadeModel;
import com.modulo5.catalisa4desafio3.model.EstadoModel;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class CidadeDTO {
    @NotBlank(message = "Nome da cidade deve ser preenchido.")
    private String nomeCidade;

    @NotNull(message = "Estado deve ser preenchido.")
    private EstadoModel estado;

    public CidadeModel converterParaObjeto() {
        return new CidadeModel(nomeCidade, estado);
    }
}
