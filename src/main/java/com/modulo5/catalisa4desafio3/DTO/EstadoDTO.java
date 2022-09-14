package com.modulo5.catalisa4desafio3.DTO;

import com.modulo5.catalisa4desafio3.model.EstadoModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class EstadoDTO {
    @NotBlank(message = "UF deve ser preenchida.")
    @Length(min = 2, message = "UF deve possuir apenas {min} caracteres.")
    private String uf;

    @NotBlank(message = "Nome do estado deve ser preenchido.")
    @Length(min = 4, max = 20, message = "Nome do estado deve possuir de {min} a {max} caracteres.")
    private String nomeEstado;

    public EstadoModel converterParaObjeto() {
        return new EstadoModel(uf, nomeEstado);
    }
}
