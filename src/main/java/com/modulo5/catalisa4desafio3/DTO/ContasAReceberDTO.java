package com.modulo5.catalisa4desafio3.DTO;

import com.modulo5.catalisa4desafio3.enumeration.RecebimentoAlugueis;
import com.modulo5.catalisa4desafio3.enumeration.TipoRecebido;
import com.modulo5.catalisa4desafio3.model.ContasAReceberModel;
import com.modulo5.catalisa4desafio3.model.UsuarioModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ContasAReceberDTO {
    private String status;

    @NotBlank(message = "Recebimento deve ser preenchido.")
    private String recebimento;

    @Min(value = 1, message = "Valor recebido deve ser preenchido.")
    private BigDecimal valorRecebido;

    private BigDecimal valorFinal;

    @NotNull(message = "Tipo recebido deve ser preenchido.")
    private TipoRecebido tipoRecebido;

    private RecebimentoAlugueis recebimentoAlugueis;

    @NotNull(message = "Data de vencimento deve ser preenchida.")
    private LocalDate dataDeVencimento;

    private LocalDateTime dataDeRecebimento;

    @NotNull(message = "Usuário deve ser preenchido.")
    private UsuarioModel usuario;

    public ContasAReceberModel converterParaObjeto() {
        return new ContasAReceberModel(status, recebimento, valorRecebido, valorFinal, tipoRecebido, recebimentoAlugueis, dataDeVencimento, dataDeRecebimento, usuario);
    }
}
