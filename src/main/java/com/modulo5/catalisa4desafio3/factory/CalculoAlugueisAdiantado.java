package com.modulo5.catalisa4desafio3.factory;

import java.math.BigDecimal;

public class CalculoAlugueisAdiantado implements CalculoAlugueis {
    @Override
    public BigDecimal calcular(BigDecimal valorAReceber) {
        BigDecimal desconto = valorAReceber.multiply(new BigDecimal("0.05"));
        BigDecimal resultado = valorAReceber.add(desconto);
        return resultado;
    }
}
