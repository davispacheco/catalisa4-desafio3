package com.modulo5.catalisa4desafio3.repository;

import com.modulo5.catalisa4desafio3.enumeration.TipoRecebido;
import com.modulo5.catalisa4desafio3.model.ContasAReceberModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ContasAReceberRepository extends JpaRepository<ContasAReceberModel, Long> {
    List<ContasAReceberModel> findByStatus(String status);

    List<ContasAReceberModel> findByTipoRecebido(TipoRecebido tipoRecebido);

    List<ContasAReceberModel> findByDataDeVencimento(LocalDate dataDeVencimento);
}
