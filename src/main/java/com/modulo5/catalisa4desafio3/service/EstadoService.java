package com.modulo5.catalisa4desafio3.service;

import com.modulo5.catalisa4desafio3.model.EstadoModel;
import com.modulo5.catalisa4desafio3.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {
    @Autowired
    private EstadoRepository estadoRepository;

    public List<EstadoModel> buscarTodos() {
        return estadoRepository.findAll();
    }

    public Optional<EstadoModel> buscarPorId(Long codigo) {
        return estadoRepository.findById(codigo);
    }

    public EstadoModel cadastrar(EstadoModel estadoModel) {
        return estadoRepository.save(estadoModel);
    }

    public EstadoModel alterar(EstadoModel estadoModel) {
        return estadoRepository.save(estadoModel);
    }

    public void deletar(Long codigo) {
        estadoRepository.deleteById(codigo);
    }
}
