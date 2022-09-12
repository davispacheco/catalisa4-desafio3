package com.modulo5.catalisa4desafio3.controller;

import com.modulo5.catalisa4desafio3.model.ContasAReceberModel;
import com.modulo5.catalisa4desafio3.service.ContasAReceberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ContasAReceberController {
    @Autowired
    private ContasAReceberService contasAReceberService;

    @GetMapping(path = "/contasreceber")
    public ResponseEntity<List<ContasAReceberModel>> buscarTodasContas() {
        return ResponseEntity.ok(contasAReceberService.buscarTodas());
    }

    @GetMapping(path = "/contasreceber/{id}")
    public ResponseEntity<Optional<ContasAReceberModel>> buscarContaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(contasAReceberService.buscarPorId(id));
    }

    @PostMapping(path = "/contasreceber")
    public ResponseEntity<ContasAReceberModel> cadastrarConta(@RequestBody ContasAReceberModel contasAReceberModel) {
        return new ResponseEntity<>(contasAReceberService.cadastrar(contasAReceberModel), HttpStatus.CREATED);
    }

    @PutMapping(path = "/contasreceber/{id}")
    public ResponseEntity<ContasAReceberModel> alterarConta(@RequestBody ContasAReceberModel contasAReceberModel, @PathVariable Long id) {
        return ResponseEntity.ok(contasAReceberService.alterar(contasAReceberModel));
    }

    @DeleteMapping(path = "/contasreceber/{id}")
    public ResponseEntity<?> deletarConta(@PathVariable Long id) {
        contasAReceberService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
