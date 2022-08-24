package com.modulo5.catalisa4desafio3.service;

import com.modulo5.catalisa4desafio3.model.ContasAPagarModel;
import com.modulo5.catalisa4desafio3.model.enums.Status;
import com.modulo5.catalisa4desafio3.repository.ContasAPagarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContasAPagarService {
    @Autowired
    private ContasAPagarRepository contasAPagarRepository;

    public List<ContasAPagarModel> buscarTodas() {
        return contasAPagarRepository.findAll();
    }

    public Optional<ContasAPagarModel> buscarPorId(Long id) {
        return contasAPagarRepository.findById(id);
    }

    public ContasAPagarModel cadastrar(ContasAPagarModel contasAPagarModel) {
        LocalDateTime dataAtual = LocalDateTime.now();
        if (contasAPagarModel.getDataDeVencimento().isAfter(dataAtual.toLocalDate())) {
            contasAPagarModel.setStatus(Status.VENCIDA);
        } else {
            contasAPagarModel.setStatus(Status.AGUARDANDO);
        }
        contasAPagarModel.getId();
        contasAPagarModel.getNome();
        contasAPagarModel.getValor();
        contasAPagarModel.getTipo();
        contasAPagarModel.getDataDeVencimento();
        contasAPagarModel.getStatus();
        return contasAPagarRepository.save(contasAPagarModel);
    }

    public ContasAPagarModel alterar(ContasAPagarModel contasAPagarModel, Long id) {
        if (contasAPagarModel.getStatus().equals(Status.PAGA)) {
            LocalDateTime dataAtual = LocalDateTime.now();
            contasAPagarModel.setDataDePagamento(dataAtual);
        }
        contasAPagarModel.getId();
        contasAPagarModel.getNome();
        contasAPagarModel.getTipo();
        contasAPagarModel.getDataDeVencimento();
        contasAPagarModel.getStatus();
        return contasAPagarRepository.save(contasAPagarModel);
    }

    public void deletar(Long id) {
        contasAPagarRepository.deleteById(id);
    }
}
