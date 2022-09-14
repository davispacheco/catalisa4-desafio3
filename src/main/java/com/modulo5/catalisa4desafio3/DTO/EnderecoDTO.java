package com.modulo5.catalisa4desafio3.DTO;

import com.modulo5.catalisa4desafio3.model.CidadeModel;
import com.modulo5.catalisa4desafio3.model.EnderecoModel;
import com.modulo5.catalisa4desafio3.model.UsuarioModel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class EnderecoDTO {
    @NotBlank(message = "Logradouro deve ser preenchido.")
    @Length(min = 5, max = 30, message = "Logradouro deve possuir de {min} a {max} caracteres.")
    private String logradouro;

    @NotBlank(message = "Bairro deve ser preenchido.")
    @Length(min = 5, max = 20, message = "Bairro deve possuir de {min} a {max} caracteres.")
    private String bairro;

    @NotBlank(message = "CEP deve ser preenchido.")
    private String cep;

    @NotBlank(message = "Ponto de referência deve ser preenchido.")
    @Length(min = 5, max = 40, message = "Ponto de referência deve possuir de {min} a {max} caracteres.")
    private String pontoReferencia;

    @NotNull(message = "Cidade deve ser preenchida.")
    private CidadeModel cidade;

    @NotNull(message = "Usuário deve ser preenchido.")
    private UsuarioModel usuario;

    public EnderecoModel converterParaObjeto() {
        return new EnderecoModel(logradouro, bairro, cep, pontoReferencia, cidade, usuario);
    }
}
