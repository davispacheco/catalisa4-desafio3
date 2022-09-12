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

    @GetMapping(path = "/contasreceber/{codigo}")
    public ResponseEntity<Optional<ContasAReceberModel>> buscarContaPorId(@PathVariable Long codigo) {
        return contasAReceberService.buscarPorId(codigo);
    }

    @PostMapping(path = "/contasreceber")
    public ResponseEntity<ContasAReceberModel> cadastrarConta(@RequestBody ContasAReceberModel contasAReceberModel) {
        return new ResponseEntity<>(contasAReceberService.cadastrar(contasAReceberModel), HttpStatus.CREATED);
    }

    @PutMapping(path = "/contasreceber/{codigo}")
    public ResponseEntity<ContasAReceberModel> alterarConta(@RequestBody ContasAReceberModel contasAReceberModel, @PathVariable Long codigo) {
        return ResponseEntity.ok(contasAReceberService.alterar(contasAReceberModel));
    }

    @DeleteMapping(path = "/contasreceber/{codigo}")
    public ResponseEntity<?> deletarConta(@PathVariable Long codigo) {
        contasAReceberService.deletar(codigo);
        return ResponseEntity.noContent().build();
    }
}
