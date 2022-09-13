package com.modulo5.catalisa4desafio3.DTO;

import com.modulo5.catalisa4desafio3.model.UsuarioModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UsuarioRespostaDTO {
    private Long codigo;
    private String nomeUsuario;
    private LocalDate dataNascimento;
    private String email;

    public static UsuarioRespostaDTO converterParaDTO(UsuarioModel usuario) {
        return new UsuarioRespostaDTO(usuario.getCodigo(), usuario.getNomeUsuario(), usuario.getDataNascimento(), usuario.getEmail());
    }

    public static List<UsuarioRespostaDTO> converterLista(List<UsuarioModel> usuarios) {
        List<UsuarioRespostaDTO> novaLista = new ArrayList<>();
        for (UsuarioModel usuario : usuarios) {
            UsuarioRespostaDTO novoUsuario = new UsuarioRespostaDTO(usuario.getCodigo(), usuario.getNomeUsuario(), usuario.getDataNascimento(), usuario.getEmail());
            novaLista.add(novoUsuario);
        }
        return novaLista;
    }
}
