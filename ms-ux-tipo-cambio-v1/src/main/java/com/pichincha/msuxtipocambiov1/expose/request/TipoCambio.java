package com.pichincha.msuxtipocambiov1.expose.request;

import lombok.*;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class TipoCambio {

    private Long id;
    private String monedaBase;
    private String monedaDestino;
    private BigDecimal tasaCambio;
    private LocalDateTime fechaHora;
    private String proveedor;

}
