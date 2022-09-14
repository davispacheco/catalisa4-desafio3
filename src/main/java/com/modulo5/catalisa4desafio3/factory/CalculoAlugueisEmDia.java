package com.modulo5.catalisa4desafio3.factory;

import java.math.BigDecimal;

public class CalculoAlugueisEmDia implements CalculoAlugueis {
    @Override
    public BigDecimal calcular(BigDecimal valorAReceber) {
        return valorAReceber;
    }
}
