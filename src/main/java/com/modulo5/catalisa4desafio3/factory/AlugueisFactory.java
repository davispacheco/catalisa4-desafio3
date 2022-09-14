package com.modulo5.catalisa4desafio3.factory;

import com.modulo5.catalisa4desafio3.enumeration.RecebimentoAlugueis;

public class AlugueisFactory {
    public CalculoAlugueis getCalculoAluguel(RecebimentoAlugueis recebimentoAlugueis) {
        if (recebimentoAlugueis.equals(recebimentoAlugueis.getAdiantado())) {
return new CalculoAlugueisAdiantado();
        } else if (recebimentoAlugueis.equals(recebimentoAlugueis.getEmDia())) {
            return new CalculoAlugueisEmDia();
        } else if (recebimentoAlugueis.equals(recebimentoAlugueis.getEmAtraso())) {
            return new CalculoAlugueisEmAtraso();
        } else {
            return null;
        }
    }
}
