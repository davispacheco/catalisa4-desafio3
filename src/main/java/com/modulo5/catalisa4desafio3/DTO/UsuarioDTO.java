package com.modulo5.catalisa4desafio3.DTO;

import com.modulo5.catalisa4desafio3.model.UsuarioModel;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
public class UsuarioDTO {
    @NotBlank(message = "Nome do usuário deve ser preenchido.")
    private String nomeUsuario;

    @NotNull(message = "Data de nascimento deve ser preenchida.")
    private LocalDate dataNascimento;

    @NotBlank(message = "E-mail deve ser preenchido.")
    private String email;

    @NotBlank(message = "CPF deve ser preenchido.")
    private String cpf;

    public UsuarioModel converterParaObjeto() {
        return new UsuarioModel(nomeUsuario, dataNascimento, email, cpf);
    }
}
