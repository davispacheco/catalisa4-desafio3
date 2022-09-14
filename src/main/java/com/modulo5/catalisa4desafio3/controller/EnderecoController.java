package com.modulo5.catalisa4desafio3.controller;

import com.modulo5.catalisa4desafio3.DTO.EnderecoDTO;
import com.modulo5.catalisa4desafio3.DTO.EnderecoRespostaDTO;
import com.modulo5.catalisa4desafio3.model.EnderecoModel;
import com.modulo5.catalisa4desafio3.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping(path = "/enderecos")
    public ResponseEntity<List<EnderecoRespostaDTO>> buscarTodosEnderecos() {
        return ResponseEntity.ok(enderecoService.buscarTodos());
    }

    @GetMapping(path = "/enderecos/{id}")
    public ResponseEntity<Optional<EnderecoModel>> buscarEnderecoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(enderecoService.buscarPorId(id));
    }

    @PostMapping(path = "/enderecos")
    public ResponseEntity<EnderecoRespostaDTO> cadastrarEndereco(@Valid @RequestBody EnderecoDTO dto) {
        EnderecoModel endereco = enderecoService.cadastrar(dto.converterParaObjeto());
        return new ResponseEntity<>(EnderecoRespostaDTO.converterParaDTO(endereco), HttpStatus.CREATED);
    }

    @PutMapping(path = "/enderecos/{id}")
    public ResponseEntity<EnderecoRespostaDTO> alterarEndereco(@RequestBody EnderecoDTO dto, @PathVariable Long id) {
        EnderecoModel endereco = enderecoService.alterar(dto.converterParaObjeto());
        return ResponseEntity.ok(EnderecoRespostaDTO.converterParaDTO(endereco));
    }

    @DeleteMapping(path = "/enderecos/{id}")
    public ResponseEntity<?> deletarEndereco(@PathVariable Long id) {
        enderecoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
