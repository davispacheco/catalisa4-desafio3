package com.modulo5.catalisa4desafio3.controller;

import com.modulo5.catalisa4desafio3.model.EnderecoModel;
import com.modulo5.catalisa4desafio3.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    public ResponseEntity<List<EnderecoModel>> buscarTodosEnderecos() {
        return ResponseEntity.ok(enderecoService.buscarTodos());
    }

    public ResponseEntity<Optional<EnderecoModel>> buscarEnderecoPorId(@PathVariable Long codigo) {
        return ResponseEntity.ok(enderecoService.buscarPorId(codigo));
    }

    public ResponseEntity<EnderecoModel> cadastrarEndereco(@RequestBody EnderecoModel enderecoModel) {
        return new ResponseEntity<>(enderecoService.cadastrar(enderecoModel), HttpStatus.CREATED);
    }

    public ResponseEntity<EnderecoModel> alterarEndereco(@RequestBody EnderecoModel enderecoModel, @PathVariable Long codigo) {
        return ResponseEntity.ok(enderecoService.alterar(enderecoModel));
    }

    public ResponseEntity<?> deletarEndereco(@PathVariable Long codigo) {
        enderecoService.deletar(codigo);
        return ResponseEntity.noContent().build();
    }
}
