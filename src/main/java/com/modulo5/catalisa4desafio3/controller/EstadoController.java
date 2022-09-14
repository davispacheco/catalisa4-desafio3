package com.modulo5.catalisa4desafio3.controller;

import com.modulo5.catalisa4desafio3.DTO.EstadoDTO;
import com.modulo5.catalisa4desafio3.DTO.EstadoRespostaDTO;
import com.modulo5.catalisa4desafio3.model.EstadoModel;
import com.modulo5.catalisa4desafio3.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class EstadoController {
    @Autowired
    private EstadoService estadoService;

    @GetMapping(path = "/estados")
    public ResponseEntity<List<EstadoRespostaDTO>> buscarTodosEstados() {
        return ResponseEntity.ok(estadoService.buscarTodos());
    }

    @GetMapping(path = "/estados/{id}")
    public ResponseEntity<Optional<EstadoModel>> buscarEstadoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(estadoService.buscarPorId(id));
    }

    @PostMapping(path = "/estados")
    public ResponseEntity<EstadoRespostaDTO> cadastrarEstado(@Valid @RequestBody EstadoDTO dto) {
        EstadoModel estado = estadoService.cadastrar(dto.converterParaObjeto());
        return new ResponseEntity<>(EstadoRespostaDTO.converterParaDTO(estado), HttpStatus.CREATED);
    }

    @PutMapping(path = "/estados/{id}")
    public ResponseEntity<EstadoRespostaDTO> alterarEstado(@RequestBody EstadoDTO dto, @PathVariable Long id) {
        EstadoModel estado = estadoService.alterar(dto.converterParaObjeto());
        return ResponseEntity.ok(EstadoRespostaDTO.converterParaDTO(estado));
    }

    @DeleteMapping(path = "/estados/{id}")
    public ResponseEntity<?> deletarEstado(@PathVariable Long id) {
        estadoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
