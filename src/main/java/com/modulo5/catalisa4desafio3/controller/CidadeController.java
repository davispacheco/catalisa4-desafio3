package com.modulo5.catalisa4desafio3.controller;

import com.modulo5.catalisa4desafio3.DTO.CidadeDTO;
import com.modulo5.catalisa4desafio3.DTO.CidadeRespostaDTO;
import com.modulo5.catalisa4desafio3.model.CidadeModel;
import com.modulo5.catalisa4desafio3.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class CidadeController {
    @Autowired
    private CidadeService cidadeService;

    @GetMapping(path = "/cidades")
    public ResponseEntity<List<CidadeRespostaDTO>> buscarTodasCidades() {
        return ResponseEntity.ok(cidadeService.buscarTodas());
    }

    @GetMapping(path = "/cidades/{id}")
    public ResponseEntity<Optional<CidadeModel>> buscarCidadePorId(@PathVariable Long id) {
        return ResponseEntity.ok(cidadeService.buscarPorId(id));
    }

    @PostMapping(path = "/cidades")
    public ResponseEntity<CidadeRespostaDTO> cadastrarCidade(@Valid @RequestBody CidadeDTO dto) {
        CidadeModel cidade = cidadeService.cadastrar(dto.converterParaObjeto());
        return new ResponseEntity<>(CidadeRespostaDTO.converterParaDTO(cidade), HttpStatus.CREATED);
    }

    @PutMapping(path = "/cidades/{id}")
    public ResponseEntity<CidadeRespostaDTO> alterarCidade(@RequestBody CidadeDTO dto, @PathVariable Long id) {
        CidadeModel cidade = cidadeService.alterar(dto.converterParaObjeto());
        return ResponseEntity.ok(CidadeRespostaDTO.converterParaDTO(cidade));
    }

    @DeleteMapping(path = "/cidades/{id}")
    public ResponseEntity<?> deletarCidade(@PathVariable Long id) {
        cidadeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
