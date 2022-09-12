package com.modulo5.catalisa4desafio3.DTO;

import com.modulo5.catalisa4desafio3.model.UsuarioModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UsuarioRespostaDTO {
    private Long codigo;
    private String nomeUsuario;
    private LocalDate dataNascimento;
    private String email;

    public static UsuarioRespostaDTO converterParaDTO(UsuarioModel usuarioModel) {
        return new UsuarioRespostaDTO(usuarioModel.getCodigo(), usuarioModel.getNomeUsuario(), usuarioModel.getDataNascimento(), usuarioModel.getEmail());
    }
}
