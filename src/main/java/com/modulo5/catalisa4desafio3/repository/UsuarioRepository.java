package com.modulo5.catalisa4desafio3.repository;

import com.modulo5.catalisa4desafio3.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
}
