package com.modulo5.catalisa4desafio3.controller;

import com.modulo5.catalisa4desafio3.model.ContasAPagarModel;
import com.modulo5.catalisa4desafio3.service.ContasAPagarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ContasAPagarController {
    @Autowired
    private ContasAPagarService contasAPagarService;

    @GetMapping(path = "/contas")
    public ResponseEntity<List<ContasAPagarModel>> buscarTodasContas() {
        return ResponseEntity.ok(contasAPagarService.buscarTodas());
    }

    @GetMapping(path = "/contas/{id}")
    public ResponseEntity<Optional<ContasAPagarModel>> buscarContaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(contasAPagarService.buscarPorId(id));
    }

    @PostMapping(path = "/contas")
    public ResponseEntity<ContasAPagarModel> cadastrarConta(ContasAPagarModel contasAPagarModel) {
        return new ResponseEntity<>(contasAPagarService.cadastrar(contasAPagarModel), HttpStatus.CREATED);
    }

    @PutMapping(path = "/contas/{id}")
    public ResponseEntity<ContasAPagarModel> alterarConta(ContasAPagarModel contasAPagarModel, @PathVariable Long id) {
        return ResponseEntity.ok(contasAPagarService.alterar(contasAPagarModel, id));
    }

    @DeleteMapping(path = "/contas/{id}")
    public void deletarConta(@PathVariable Long id) {
        contasAPagarService.deletar(id);
    }
}
