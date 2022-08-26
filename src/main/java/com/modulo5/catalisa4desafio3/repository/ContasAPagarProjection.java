package com.modulo5.catalisa4desafio3.repository;

import com.modulo5.catalisa4desafio3.model.enums.Status;

public interface ContasAPagarProjection {
    Long getId();
    String getNome();
    double getValor();
    Status getStatus();
}
