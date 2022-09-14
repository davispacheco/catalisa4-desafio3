package com.modulo5.catalisa4desafio3.DTO;

import com.modulo5.catalisa4desafio3.enumeration.RecebimentoAlugueis;
import com.modulo5.catalisa4desafio3.enumeration.TipoRecebido;
import com.modulo5.catalisa4desafio3.model.ContasAReceberModel;
import com.modulo5.catalisa4desafio3.model.UsuarioModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ContasAReceberRespostaDTO {
    private Long codigo;
    private String status;
    private String recebimento;
    private BigDecimal valorRecebido;
    private BigDecimal valorFinal;
    private TipoRecebido tipoRecebido;
    private RecebimentoAlugueis recebimentoAlugueis;
    private LocalDate dataDeVencimento;
    private LocalDateTime dataDeRecebimento;
    private UsuarioModel usuario;

    public static ContasAReceberRespostaDTO converterParaDTO(ContasAReceberModel contasAReceberModel) {
        return new ContasAReceberRespostaDTO(contasAReceberModel.getCodigo(), contasAReceberModel.getStatus(), contasAReceberModel.getRecebimento(), contasAReceberModel.getValorRecebido(), contasAReceberModel.getValorFinal(), contasAReceberModel.getTipoRecebido(), contasAReceberModel.getRecebimentoAlugueis(), contasAReceberModel.getDataDeVencimento(), contasAReceberModel.getDataDeRecebimento(), contasAReceberModel.getUsuario());
    }

    public static List<ContasAReceberRespostaDTO> converterLista(List<ContasAReceberModel> contas) {
        List<ContasAReceberRespostaDTO> novaLista = new ArrayList<>();
        for (ContasAReceberModel conta : contas) {
            ContasAReceberRespostaDTO novaConta = new ContasAReceberRespostaDTO(conta.getCodigo(), conta.getStatus(), conta.getRecebimento(), conta.getValorRecebido(), conta.getValorFinal(), conta.getTipoRecebido(), conta.getRecebimentoAlugueis(), conta.getDataDeVencimento(), conta.getDataDeRecebimento(), conta.getUsuario());
            novaLista.add(novaConta);
        }
        return novaLista;
    }
}
