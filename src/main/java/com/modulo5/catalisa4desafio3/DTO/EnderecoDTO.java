package com.modulo5.catalisa4desafio3.DTO;

import com.modulo5.catalisa4desafio3.model.CidadeModel;
import com.modulo5.catalisa4desafio3.model.EnderecoModel;
import com.modulo5.catalisa4desafio3.model.UsuarioModel;
import lombok.Getter;

@Getter
public class EnderecoDTO {
    private String logradouro;
    private String bairro;
    private String cep;
    private String pontoReferencia;
    private CidadeModel cidade;
    private UsuarioModel usuario;

    public EnderecoModel converterParaObjeto() {
        return new EnderecoModel(logradouro, bairro, cep, pontoReferencia, cidade, usuario);
    }
}
