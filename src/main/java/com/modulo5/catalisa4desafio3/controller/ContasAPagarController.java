package com.modulo5.catalisa4desafio3.controller;

import com.modulo5.catalisa4desafio3.DTO.ContasAPagarDTO;
import com.modulo5.catalisa4desafio3.DTO.ContasAPagarRespostaDTO;
import com.modulo5.catalisa4desafio3.model.ContasAPagarModel;
import com.modulo5.catalisa4desafio3.enumeration.Status;
import com.modulo5.catalisa4desafio3.enumeration.Tipo;
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
    public ResponseEntity<List<ContasAPagarRespostaDTO>> buscarTodasContas() {
        return ResponseEntity.ok(contasAPagarService.buscarTodas());
    }

    @GetMapping(path = "/contas/{id}")
    public ResponseEntity<Optional<ContasAPagarModel>> buscarContaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(contasAPagarService.buscarPorId(id));
    }

    @GetMapping(path = "/nome/{nome}")
    public ResponseEntity<List<ContasAPagarModel>> buscarContaPorNome(@PathVariable String nome) {
        return ResponseEntity.ok(contasAPagarService.buscarPorNome(nome));
    }

    @GetMapping(path = "/contas/status/{status}")
    public ResponseEntity<List<ContasAPagarModel>> buscarContaPorStatus(@PathVariable Status status) {
        return ResponseEntity.ok(contasAPagarService.buscarPorStatus(status));
    }

    @GetMapping(path = "/contas/tipo/{tipo}")
    public ResponseEntity<List<ContasAPagarModel>> buscarContaPorTipo(@PathVariable Tipo tipo) {
        return ResponseEntity.ok(contasAPagarService.buscarPorTipo(tipo));
    }

    @PostMapping(path = "/contas")
    public ResponseEntity<ContasAPagarRespostaDTO> cadastrarConta(@RequestBody ContasAPagarDTO dto) {
        ContasAPagarModel conta = contasAPagarService.cadastrar(dto.converterParaObjeto());
        return new ResponseEntity<>(ContasAPagarRespostaDTO.converterParaDTO(conta), HttpStatus.CREATED);
    }

    @PutMapping(path = "/contas/{id}")
    public ResponseEntity<ContasAPagarModel> alterarConta(@RequestBody ContasAPagarModel contasAPagarModel, @PathVariable Long id) {
        return ResponseEntity.ok(contasAPagarService.alterar(contasAPagarModel));
    }

    @DeleteMapping(path = "/contas/{id}")
    public ResponseEntity<?> deletarConta(@PathVariable Long id) {
        contasAPagarService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
