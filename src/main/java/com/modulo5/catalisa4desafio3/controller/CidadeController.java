package com.modulo5.catalisa4desafio3.controller;

import com.modulo5.catalisa4desafio3.model.CidadeModel;
import com.modulo5.catalisa4desafio3.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CidadeController {
    @Autowired
    private CidadeService cidadeService;

    public ResponseEntity<List<CidadeModel>> buscarTodasCidades() {
        return ResponseEntity.ok(cidadeService.buscarTodas());
    }

    public ResponseEntity<Optional<CidadeModel>> buscarCidadePorId(@PathVariable Long codigo) {
        return cidadeService.buscarPorId(codigo);
    }

    public ResponseEntity<CidadeModel> cadastrarCidade(@RequestBody CidadeModel cidadeModel) {
        return new ResponseEntity<>(cidadeService.cadastrar(cidadeModel), HttpStatus.CREATED);
    }

    public ResponseEntity<CidadeModel> alterarCidade(@RequestBody CidadeModel cidadeModel, @PathVariable Long codigo) {
        return ResponseEntity.ok(cidadeService.alterar(cidadeModel));
    }

    public ResponseEntity<?> deletarCidade(@PathVariable Long codigo) {
        cidadeService.deletar(codigo);
        return ResponseEntity.noContent().build();
    }
}
