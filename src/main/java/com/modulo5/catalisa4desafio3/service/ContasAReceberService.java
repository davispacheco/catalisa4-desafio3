package com.modulo5.catalisa4desafio3.service;

import com.modulo5.catalisa4desafio3.model.ContasAReceberModel;
import com.modulo5.catalisa4desafio3.repository.ContasAReceberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContasAReceberService {
    @Autowired
    private ContasAReceberRepository contasAReceberRepository;

    public List<ContasAReceberModel> buscarTodas() {
        return contasAReceberRepository.findAll();
    }

    public Optional<ContasAReceberModel> buscarPorId(Long codigo) {
        return contasAReceberRepository.findById(codigo);
    }

    public ContasAReceberModel cadastrar(ContasAReceberModel contasAReceberModel) {
        return contasAReceberRepository.save(contasAReceberModel);
    }

    public ContasAReceberModel alterar(ContasAReceberModel contasAReceberModel) {
        return contasAReceberRepository.save(contasAReceberModel);
    }

    public void deletar(Long codigo) {
        contasAReceberRepository.deleteById(codigo);
    }
}
