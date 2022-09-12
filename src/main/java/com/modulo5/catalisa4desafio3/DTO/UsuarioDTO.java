package com.modulo5.catalisa4desafio3.DTO;

import com.modulo5.catalisa4desafio3.model.UsuarioModel;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
public class UsuarioDTO {
    @NotEmpty(message = "Nome do usuário deve ser preenchido.")
    private String nomeUsuario;

    @NotEmpty(message = "Data de nascimento deve ser preenchida.")
    private LocalDate dataNascimento;

    @NotEmpty(message = "E-mail deve ser preenchido.")
    private String email;

    @NotEmpty(message = "CPF deve ser preenchido.")
    private String cpf;

    public UsuarioModel converterParaObjeto() {
        return new UsuarioModel(nomeUsuario, dataNascimento, email, cpf);
    }
}
