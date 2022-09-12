package com.modulo5.catalisa4desafio3.controller;

import com.modulo5.catalisa4desafio3.model.EstadoModel;
import com.modulo5.catalisa4desafio3.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EstadoController {
    @Autowired
    private EstadoService estadoService;

    public ResponseEntity<List<EstadoModel>> buscarTodosEstados() {
        return ResponseEntity.ok(estadoService.buscarTodos());
    }

    public ResponseEntity<Optional<EstadoModel>> buscarEstadoPorId(@PathVariable Long codigo) {
        return ResponseEntity.ok(estadoService.buscarPorId(codigo));
    }

    public ResponseEntity<EstadoModel> cadastrarEstado(@RequestBody EstadoModel estadoModel) {
        return new ResponseEntity<>(estadoService.cadastrar(estadoModel), HttpStatus.CREATED);
    }

    public ResponseEntity<EstadoModel> alterarEstado(@RequestBody EstadoModel estadoModel, @PathVariable Long codigo) {
        return ResponseEntity.ok(estadoService.alterar(estadoModel));
    }

    public ResponseEntity<?> deletarEstado(@PathVariable Long codigo) {
        estadoService.deletar(codigo);
        return ResponseEntity.noContent().build();
    }
}
