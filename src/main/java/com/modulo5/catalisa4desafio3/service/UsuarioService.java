package com.modulo5.catalisa4desafio3.service;

import com.modulo5.catalisa4desafio3.DTO.UsuarioRespostaDTO;
import com.modulo5.catalisa4desafio3.model.UsuarioModel;
import com.modulo5.catalisa4desafio3.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioRespostaDTO> buscarTodos() {
        List<UsuarioModel> usuarios = usuarioRepository.findAll();
        return UsuarioRespostaDTO.converterLista(usuarios);
    }

    public Optional<UsuarioModel> buscarPorId(Long codigo) {
        return usuarioRepository.findById(codigo);
    }

    public UsuarioModel cadastrar(UsuarioModel usuarioModel) {
        return usuarioRepository.save(usuarioModel);
    }

    public UsuarioModel alterar(UsuarioModel usuarioModel) {
        return usuarioRepository.save(usuarioModel);
    }

    public void deletar(Long codigo) {
        usuarioRepository.deleteById(codigo);
    }
}
