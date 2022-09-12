package com.modulo5.catalisa4desafio3.service;

import com.modulo5.catalisa4desafio3.model.EnderecoModel;
import com.modulo5.catalisa4desafio3.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<EnderecoModel> buscarTodos() {
        return enderecoRepository.findAll();
    }

    public Optional<EnderecoModel> buscarPorId(Long codigo) {
        return enderecoRepository.findById(codigo);
    }

    public EnderecoModel cadastrar(EnderecoModel enderecoModel) {
        return enderecoRepository.save(enderecoModel);
    }

    public EnderecoModel alterar(EnderecoModel enderecoModel) {
        return enderecoRepository.save(enderecoModel);
    }

    public void deletar(Long codigo) {
        enderecoRepository.deleteById(codigo);
    }
}
