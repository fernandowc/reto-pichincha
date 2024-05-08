package com.pichincha.mssptipocambiov1.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "tipo_cambio")
@ToString
public class TipoCambio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String monedaBase;
    @Column
    private String monedaDestino;
    @Column
    private BigDecimal tasaCambio;
    @Column
    private LocalDateTime fechaHora;
    @Column
    private String proveedor;

}
