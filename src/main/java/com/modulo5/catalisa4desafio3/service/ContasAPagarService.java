package com.modulo5.catalisa4desafio3.service;

import com.modulo5.catalisa4desafio3.DTO.ContasAPagarRespostaDTO;
import com.modulo5.catalisa4desafio3.model.ContasAPagarModel;
import com.modulo5.catalisa4desafio3.enumeration.Status;
import com.modulo5.catalisa4desafio3.enumeration.Tipo;
import com.modulo5.catalisa4desafio3.repository.ContasAPagarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContasAPagarService {
    @Autowired
    private ContasAPagarRepository contasAPagarRepository;

    public List<ContasAPagarRespostaDTO> buscarTodas() {
        List<ContasAPagarModel> contas = contasAPagarRepository.findAll();
        return ContasAPagarRespostaDTO.converterLista(contas);
    }

    public Optional<ContasAPagarModel> buscarPorId(Long id) {
        return contasAPagarRepository.findById(id);
    }

    public List<ContasAPagarModel> buscarPorNome(String nome) {
        return contasAPagarRepository.findByNome(nome);
    }

    public List<ContasAPagarModel> buscarPorStatus(Status status) {
        return contasAPagarRepository.findByStatus(status);
    }

    public List<ContasAPagarModel> buscarPorTipo(Tipo tipo) {
        return contasAPagarRepository.findByTipo(tipo);
    }

    public ContasAPagarModel cadastrar(ContasAPagarModel contasAPagarModel) {
        LocalDate dataAtual = LocalDate.now();
        if (contasAPagarModel.getDataDeVencimento().isBefore(dataAtual)) {
            contasAPagarModel.setStatus(Status.VENCIDA);
        } else {
            contasAPagarModel.setStatus(Status.AGUARDANDO);
        }
        return contasAPagarRepository.save(contasAPagarModel);
    }

    public ContasAPagarModel alterar(ContasAPagarModel contasAPagarModel) {
        if (contasAPagarModel.getStatus().equals(Status.PAGO)) {
            LocalDateTime dataAtual = LocalDateTime.now();
            contasAPagarModel.setDataDePagamento(dataAtual);
        }
        return contasAPagarRepository.save(contasAPagarModel);
    }

    public void deletar(Long codigo) {
        contasAPagarRepository.deleteById(codigo);
    }
}
