package com.pichincha.mssptipocambiov1.expose.response;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SolicitudResponse {
    private Long id;
    private String usuarioSolicitante;
    private BigDecimal monto;
    private String monedaOrigen;
    private String monedaDestino;
    private BigDecimal montoCambiado;
    private LocalDateTime fechaProceso;

}
