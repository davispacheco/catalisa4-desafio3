package com.modulo5.catalisa4desafio3.model;

import com.modulo5.catalisa4desafio3.enumeration.RecebimentoAlugueis;
import com.modulo5.catalisa4desafio3.enumeration.TipoRecebido;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "contas_a_receber")
public class ContasAReceberModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(length = 20)
    private String status;

    @Column(length = 20, nullable = false)
    private String recebimento;

    @Column(nullable = false)
    private BigDecimal valorRecebido;

    private BigDecimal valorFinal;

    @Column(nullable = false)
    private TipoRecebido tipoRecebido;

    private RecebimentoAlugueis recebimentoAlugueis;

    @Column(nullable = false)
    private LocalDate dataDeVencimento;

    private LocalDateTime dataDeRecebimento;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "codigo")
    private UsuarioModel usuario;

    public ContasAReceberModel(String status, String recebimento, BigDecimal valorRecebido, BigDecimal valorFinal, TipoRecebido tipoRecebido, RecebimentoAlugueis recebimentoAlugueis, LocalDate dataDeVencimento, LocalDateTime dataDeRecebimento, UsuarioModel usuario) {
        this.status = status;
        this.recebimento = recebimento;
        this.valorRecebido = valorRecebido;
        this.valorFinal = valorFinal;
        this.tipoRecebido = tipoRecebido;
        this.recebimentoAlugueis = recebimentoAlugueis;
        this.dataDeVencimento = dataDeVencimento;
        this.dataDeRecebimento = dataDeRecebimento;
        this.usuario = usuario;
    }
}
