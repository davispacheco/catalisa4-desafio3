package com.modulo5.catalisa4desafio3.DTO;

import com.modulo5.catalisa4desafio3.enumeration.Status;
import com.modulo5.catalisa4desafio3.enumeration.Tipo;
import com.modulo5.catalisa4desafio3.model.ContasAPagarModel;
import com.modulo5.catalisa4desafio3.model.UsuarioModel;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class ContasAPagarDTO {
    @NotBlank(message = "Nome da conta deve ser preenchido.")
    private String nome;

    @Min(value = 1, message = "Valor da conta deve ser preenchido.")
    private double valor;

    @NotNull(message = "Tipo da conta deve ser preenchido.")
    private Tipo tipo;

    @NotNull(message = "Data de vencimento deve ser preenchida.")
    private LocalDate dataDeVencimento;

    private LocalDateTime dataDePagamento;

    private Status status;

    private UsuarioModel usuario;

    public ContasAPagarModel converterParaObjeto() {
        return new ContasAPagarModel(nome, valor, tipo, dataDeVencimento, dataDePagamento, status, usuario);
    }
}
