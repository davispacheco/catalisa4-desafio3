package com.modulo5.catalisa4desafio3.DTO;

import com.modulo5.catalisa4desafio3.model.CidadeModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class CidadeRespostaDTO {
    private Long codigo;
    private String nomeCidade;

    public static CidadeRespostaDTO converterParaDTO(CidadeModel cidadeModel) {
        return new CidadeRespostaDTO(cidadeModel.getCodigo(), cidadeModel.getNomeCidade());
    }
}
