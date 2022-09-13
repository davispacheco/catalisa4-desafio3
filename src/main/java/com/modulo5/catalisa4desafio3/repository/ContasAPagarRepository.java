package com.modulo5.catalisa4desafio3.repository;

import com.modulo5.catalisa4desafio3.model.ContasAPagarModel;
import com.modulo5.catalisa4desafio3.enumeration.Status;
import com.modulo5.catalisa4desafio3.enumeration.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContasAPagarRepository extends JpaRepository<ContasAPagarModel, Long> {
    List<ContasAPagarModel> findByNome(String nome);

    List<ContasAPagarModel> findByStatus(Status status);

    List<ContasAPagarModel> findByTipo(Tipo tipo);
}
