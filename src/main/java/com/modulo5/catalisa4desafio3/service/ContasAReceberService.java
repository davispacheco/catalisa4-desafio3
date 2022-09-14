package com.modulo5.catalisa4desafio3.service;

import com.modulo5.catalisa4desafio3.DTO.ContasAReceberRespostaDTO;
import com.modulo5.catalisa4desafio3.enumeration.RecebimentoAlugueis;
import com.modulo5.catalisa4desafio3.enumeration.TipoRecebido;
import com.modulo5.catalisa4desafio3.factory.AlugueisFactory;
import com.modulo5.catalisa4desafio3.model.ContasAReceberModel;
import com.modulo5.catalisa4desafio3.repository.ContasAReceberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ContasAReceberService {
    @Autowired
    private ContasAReceberRepository contasAReceberRepository;

    public List<ContasAReceberRespostaDTO> buscarTodas() {
        List<ContasAReceberModel> contas = contasAReceberRepository.findAll();
        return ContasAReceberRespostaDTO.converterLista(contas);
    }

    public Optional<ContasAReceberModel> buscarPorId(Long codigo) {
        return contasAReceberRepository.findById(codigo);
    }

    public List<ContasAReceberModel> buscarPorStatus(String status) {
        return contasAReceberRepository.findByStatus(status);
    }

    public List<ContasAReceberModel> buscarPorTipoRecebido(TipoRecebido tipoRecebido) {
        return contasAReceberRepository.findByTipoRecebido(tipoRecebido);
    }

    public List<ContasAReceberModel> buscarPorDataDeVencimento(LocalDate dataDeVencimento) {
        return contasAReceberRepository.findByDataDeVencimento(dataDeVencimento);
    }

    public ContasAReceberModel cadastrar(ContasAReceberModel contasAReceberModel, AlugueisFactory alugueisFactory) {
        if (contasAReceberModel.getTipoRecebido().equals(TipoRecebido.ALUGUEIS)) {
            LocalDate dataAtual = LocalDate.now();
            if (contasAReceberModel.getDataDeVencimento().isBefore(dataAtual)) {
                contasAReceberModel.setRecebimentoAlugueis(RecebimentoAlugueis.EM_ATRASO);
            } else if (contasAReceberModel.getDataDeVencimento().isAfter(dataAtual)) {
                contasAReceberModel.setRecebimentoAlugueis(RecebimentoAlugueis.ADIANTADO);
            } else {
                contasAReceberModel.setRecebimentoAlugueis(RecebimentoAlugueis.EM_DIA);
            }
            BigDecimal resultado = alugueisFactory.getCalculoAluguel(contasAReceberModel).calcular(contasAReceberModel.getValorRecebido());
            contasAReceberModel.setValorFinal(resultado);
        }
        return contasAReceberRepository.save(contasAReceberModel);
    }

    public ContasAReceberModel alterar(ContasAReceberModel contasAReceberModel) {
        return contasAReceberRepository.save(contasAReceberModel);
    }

    public void deletar(Long codigo) {
        contasAReceberRepository.deleteById(codigo);
    }
}
