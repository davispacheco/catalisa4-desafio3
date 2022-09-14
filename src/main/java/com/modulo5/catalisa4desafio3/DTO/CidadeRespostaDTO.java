package com.modulo5.catalisa4desafio3.DTO;

import com.modulo5.catalisa4desafio3.model.CidadeModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class CidadeRespostaDTO {
    private Long codigo;
    private String nomeCidade;

    public static CidadeRespostaDTO converterParaDTO(CidadeModel cidadeModel) {
        return new CidadeRespostaDTO(cidadeModel.getCodigo(), cidadeModel.getNomeCidade());
    }

    public static List<CidadeRespostaDTO> converterLista(List<CidadeModel> cidades) {
        List<CidadeRespostaDTO> novaLista = new ArrayList<>();
        for (CidadeModel cidade : cidades) {
            CidadeRespostaDTO novaCidade = new CidadeRespostaDTO(cidade.getCodigo(), cidade.getNomeCidade());
            novaLista.add(novaCidade);
        }
        return novaLista;
    }
}
