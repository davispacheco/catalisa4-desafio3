package com.modulo5.catalisa4desafio3.controller;

import com.modulo5.catalisa4desafio3.DTO.ContasAReceberDTO;
import com.modulo5.catalisa4desafio3.DTO.ContasAReceberRespostaDTO;
import com.modulo5.catalisa4desafio3.enumeration.TipoRecebido;
import com.modulo5.catalisa4desafio3.factory.AlugueisFactory;
import com.modulo5.catalisa4desafio3.model.ContasAReceberModel;
import com.modulo5.catalisa4desafio3.service.ContasAReceberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class ContasAReceberController {
    @Autowired
    private ContasAReceberService contasAReceberService;

    @GetMapping(path = "/contasreceber")
    public ResponseEntity<List<ContasAReceberRespostaDTO>> buscarTodasContas() {
        return ResponseEntity.ok(contasAReceberService.buscarTodas());
    }

    @GetMapping(path = "/contasreceber/{id}")
    public ResponseEntity<Optional<ContasAReceberModel>> buscarContaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(contasAReceberService.buscarPorId(id));
    }

    @GetMapping(path = "/contasreceber/status/{status}")
    public ResponseEntity<List<ContasAReceberModel>> buscarContaPorStatus(@PathVariable String status) {
        return ResponseEntity.ok(contasAReceberService.buscarPorStatus(status));
    }

    @GetMapping(path = "/contasreceber/tiporecebido/{tipoRecebido}")
    public ResponseEntity<List<ContasAReceberModel>> buscarContaPorTipoRecebido(@PathVariable TipoRecebido tipoRecebido) {
        return ResponseEntity.ok(contasAReceberService.buscarPorTipoRecebido(tipoRecebido));
    }

    @GetMapping(path = "/contasreceber/datadevencimento/{dataDeVencimento}")
    public ResponseEntity<List<ContasAReceberModel>> buscarContaPorDataDeVencimento(@PathVariable String dataDeVencimento) {
        return ResponseEntity.ok(contasAReceberService.buscarPorDataDeVencimento(dataDeVencimento));
    }
    @PostMapping(path = "/contasreceber")
    public ResponseEntity<ContasAReceberRespostaDTO> cadastrarConta(@Valid @RequestBody ContasAReceberDTO dto, AlugueisFactory alugueisFactory) {
        ContasAReceberModel conta = contasAReceberService.cadastrar(dto.converterParaObjeto(), alugueisFactory);
        return new ResponseEntity<>(ContasAReceberRespostaDTO.converterParaDTO(conta), HttpStatus.CREATED);
    }

    @PutMapping(path = "/contasreceber/{id}")
    public ResponseEntity<ContasAReceberRespostaDTO> alterarConta(@RequestBody ContasAReceberDTO dto, @PathVariable Long id) {
        ContasAReceberModel conta = contasAReceberService.alterar(dto.converterParaObjeto());
        return ResponseEntity.ok(ContasAReceberRespostaDTO.converterParaDTO(conta));
    }

    @DeleteMapping(path = "/contasreceber/{id}")
    public ResponseEntity<?> deletarConta(@PathVariable Long id) {
        contasAReceberService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
