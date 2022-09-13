package com.modulo5.catalisa4desafio3.DTO;

import com.modulo5.catalisa4desafio3.model.EstadoModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class EstadoRespostaDTO {
    private Long codigo;
    private String uf;
    private String nomeEstado;

    public static EstadoRespostaDTO converterParaDTO(EstadoModel estado) {
        return new EstadoRespostaDTO(estado.getCodigo(), estado.getUf(), estado.getNomeEstado());
    }

    public static List<EstadoRespostaDTO> converterLista(List<EstadoModel> estados) {
        List<EstadoRespostaDTO> novaLista = new ArrayList<>();
        for (EstadoModel estado : estados) {
            EstadoRespostaDTO novoEstado = new EstadoRespostaDTO(estado.getCodigo(), estado.getUf(), estado.getNomeEstado());
            novaLista.add(novoEstado);
        }
        return novaLista;
    }
}
