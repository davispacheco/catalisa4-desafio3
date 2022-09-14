package com.modulo5.catalisa4desafio3.model;

import com.modulo5.catalisa4desafio3.enumeration.TipoRecebido;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "contas_a_receber")
public class ContasAReceberModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(length = 20, nullable = false)
    private String status;

    @Column(length = 20, nullable = false)
    private String recebimento;

    @Column(nullable = false)
    private BigDecimal valorRecebido;

    @Column(nullable = false)
    private TipoRecebido tipoRecebido;

    @Column(nullable = false)
    private LocalDate dataDeVencimento;

    private LocalDateTime dataDeRecebimento;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "codigo")
    private UsuarioModel usuario;

    public ContasAReceberModel(String status, String recebimento, BigDecimal valorRecebido, TipoRecebido tipoRecebido, LocalDate dataDeVencimento, LocalDateTime dataDeRecebimento, UsuarioModel usuario) {
        this.status = status;
        this.recebimento = recebimento;
        this.valorRecebido = valorRecebido;
        this.tipoRecebido = tipoRecebido;
        this.dataDeVencimento = dataDeVencimento;
        this.dataDeRecebimento = dataDeRecebimento;
        this.usuario = usuario;
    }
}
