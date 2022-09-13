package com.modulo5.catalisa4desafio3.controller;

import com.modulo5.catalisa4desafio3.DTO.UsuarioDTO;
import com.modulo5.catalisa4desafio3.DTO.UsuarioRespostaDTO;
import com.modulo5.catalisa4desafio3.model.UsuarioModel;
import com.modulo5.catalisa4desafio3.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(path = "/usuarios")
    public ResponseEntity<List<UsuarioRespostaDTO>> buscarTodosUsuarios() {
        return ResponseEntity.ok(usuarioService.buscarTodos());
    }

    @GetMapping(path = "/usuarios/{id}")
    public ResponseEntity<Optional<UsuarioModel>> buscarUsuarioPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscarPorId(id));
    }

    @PostMapping(path = "/usuarios")
    public ResponseEntity<UsuarioRespostaDTO> cadastrarUsuario(@Valid @RequestBody UsuarioDTO dto) {
        UsuarioModel usuario = usuarioService.cadastrar(dto.converterParaObjeto());
        return new ResponseEntity<>(UsuarioRespostaDTO.converterParaDTO(usuario), HttpStatus.CREATED);
    }

    @PutMapping(path = "/usuarios/{id}")
    public ResponseEntity<UsuarioRespostaDTO> alterarUsuario(@RequestBody UsuarioDTO dto, @PathVariable Long id) {
        UsuarioModel usuario = usuarioService.alterar(dto.converterParaObjeto());
        return ResponseEntity.ok(UsuarioRespostaDTO.converterParaDTO(usuario));
    }

    @DeleteMapping(path = "/usuarios/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
