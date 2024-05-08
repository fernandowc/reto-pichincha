package com.pichincha.msuxtipocambiov1.expose.request;

import lombok.*;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class TipoCambio {
    private Long idUsuario;
    private String usuaname;
    private BigDecimal monto;
    private String monedaOrigen;
    private String monedaDestino;
    private BigDecimal montoTipoCambio;

}
