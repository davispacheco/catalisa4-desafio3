package com.modulo5.catalisa4desafio3.repository;

import com.modulo5.catalisa4desafio3.model.EstadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<EstadoModel, Long> {
}
