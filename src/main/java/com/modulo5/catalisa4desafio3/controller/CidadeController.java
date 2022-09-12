package com.modulo5.catalisa4desafio3.controller;

import com.modulo5.catalisa4desafio3.model.CidadeModel;
import com.modulo5.catalisa4desafio3.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CidadeController {
    @Autowired
    private CidadeService cidadeService;

    @GetMapping(path = "/cidades")
    public ResponseEntity<List<CidadeModel>> buscarTodasCidades() {
        return ResponseEntity.ok(cidadeService.buscarTodas());
    }

    public ResponseEntity<Optional<CidadeModel>> buscarCidadePorId(@PathVariable Long id) {
        return ResponseEntity.ok(cidadeService.buscarPorId(id));
    }

    @PostMapping(path = "/cidades")
    public ResponseEntity<CidadeModel> cadastrarCidade(@RequestBody CidadeModel cidadeModel) {
        return new ResponseEntity<>(cidadeService.cadastrar(cidadeModel), HttpStatus.CREATED);
    }

    @PutMapping(path = "/cidades/{id}")
    public ResponseEntity<CidadeModel> alterarCidade(@RequestBody CidadeModel cidadeModel, @PathVariable Long id) {
        return ResponseEntity.ok(cidadeService.alterar(cidadeModel));
    }

    @DeleteMapping(path = "/cidades/{id}")
    public ResponseEntity<?> deletarCidade(@PathVariable Long id) {
        cidadeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
