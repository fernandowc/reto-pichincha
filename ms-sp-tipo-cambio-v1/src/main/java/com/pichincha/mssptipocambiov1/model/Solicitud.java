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
@Table(name = "solicitud")
@ToString
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String usuarioSolicitante;
    @Column
    private BigDecimal monto;
    @Column
    private String monedaOrigen;
    @Column
    private String monedaDestino;
    @Column
    private BigDecimal montoCambiado;
    @Column
    private LocalDateTime fechaProceso;

}
