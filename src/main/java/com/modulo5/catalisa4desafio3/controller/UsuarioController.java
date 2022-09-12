package com.modulo5.catalisa4desafio3.controller;

import com.modulo5.catalisa4desafio3.model.UsuarioModel;
import com.modulo5.catalisa4desafio3.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(path = "/usuarios")
    public ResponseEntity<List<UsuarioModel>> buscarTodosUsuarios() {
        return ResponseEntity.ok(usuarioService.buscarTodos());
    }

    @GetMapping(path = "/usuarios/{codigo}")
    public ResponseEntity<Optional<UsuarioModel>> buscarUsuarioPorId(@PathVariable Long codigo) {
        return ResponseEntity.ok(usuarioService.buscarPorId(codigo));
    }

    @PostMapping(path = "/usuarios")
    public ResponseEntity<UsuarioModel> cadastrarUsuario(@RequestBody UsuarioModel usuarioModel) {
        return new ResponseEntity<>(usuarioService.cadastrar(usuarioModel), HttpStatus.CREATED);
    }

    @PutMapping(path = "/usuarios/{codigo}")
    public ResponseEntity<UsuarioModel> alterarUsuario(@RequestBody UsuarioModel usuarioModel, @PathVariable Long codigo) {
        return ResponseEntity.ok(usuarioService.alterar(usuarioModel));
    }

    @DeleteMapping(path = "/usuarios/{codigo}")
    public ResponseEntity<?> deletarUsuario(@PathVariable Long codigo) {
        usuarioService.deletar(codigo);
        return ResponseEntity.noContent().build();
    }
}
