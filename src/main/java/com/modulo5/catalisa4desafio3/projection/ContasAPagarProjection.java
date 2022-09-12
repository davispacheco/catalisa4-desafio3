package com.modulo5.catalisa4desafio3.projection;

import com.modulo5.catalisa4desafio3.enumeration.Status;

public interface ContasAPagarProjection {
    Long getId();
    String getNome();
    double getValor();
    Status getStatus();
}
