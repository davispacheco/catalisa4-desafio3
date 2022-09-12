package com.modulo5.catalisa4desafio3.controller;

import com.modulo5.catalisa4desafio3.model.EnderecoModel;
import com.modulo5.catalisa4desafio3.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping(path = "/enderecos")
    public ResponseEntity<List<EnderecoModel>> buscarTodosEnderecos() {
        return ResponseEntity.ok(enderecoService.buscarTodos());
    }

    @GetMapping(path = "/enderecos/{id}")
    public ResponseEntity<Optional<EnderecoModel>> buscarEnderecoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(enderecoService.buscarPorId(id));
    }

    @PostMapping(path = "/enderecos")
    public ResponseEntity<EnderecoModel> cadastrarEndereco(@RequestBody EnderecoModel enderecoModel) {
        return new ResponseEntity<>(enderecoService.cadastrar(enderecoModel), HttpStatus.CREATED);
    }

    @PutMapping(path = "/enderecos/{id}")
    public ResponseEntity<EnderecoModel> alterarEndereco(@RequestBody EnderecoModel enderecoModel, @PathVariable Long id) {
        return ResponseEntity.ok(enderecoService.alterar(enderecoModel));
    }

    @DeleteMapping(path = "/enderecos/{id}")
    public ResponseEntity<?> deletarEndereco(@PathVariable Long id) {
        enderecoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
