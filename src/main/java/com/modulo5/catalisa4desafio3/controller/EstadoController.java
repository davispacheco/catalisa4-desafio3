package com.modulo5.catalisa4desafio3.controller;

import com.modulo5.catalisa4desafio3.model.EstadoModel;
import com.modulo5.catalisa4desafio3.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EstadoController {
    @Autowired
    private EstadoService estadoService;

    @GetMapping(path = "/estados")
    public ResponseEntity<List<EstadoModel>> buscarTodosEstados() {
        return ResponseEntity.ok(estadoService.buscarTodos());
    }

    @GetMapping(path = "/estados/{id}")
    public ResponseEntity<Optional<EstadoModel>> buscarEstadoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(estadoService.buscarPorId(id));
    }

    @PostMapping(path = "/estados")
    public ResponseEntity<EstadoModel> cadastrarEstado(@RequestBody EstadoModel estadoModel) {
        return new ResponseEntity<>(estadoService.cadastrar(estadoModel), HttpStatus.CREATED);
    }

    @PutMapping(path = "/estados/{id}")
    public ResponseEntity<EstadoModel> alterarEstado(@RequestBody EstadoModel estadoModel, @PathVariable Long id) {
        return ResponseEntity.ok(estadoService.alterar(estadoModel));
    }

    @DeleteMapping(path = "/estados/{id}")
    public ResponseEntity<?> deletarEstado(@PathVariable Long id) {
        estadoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
