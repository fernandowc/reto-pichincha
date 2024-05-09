package com.pichincha.msuxtipocambiov1.expose;

import com.pichincha.msuxtipocambiov1.expose.request.SolicitudRequest;
import com.pichincha.msuxtipocambiov1.expose.request.TipoCambio;
import com.pichincha.msuxtipocambiov1.expose.response.SolicitudResponse;
import com.pichincha.msuxtipocambiov1.service.TipoCambioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/pichincha")
@RequiredArgsConstructor
public class TipoCambioController {

    private final TipoCambioService tipoCambioService;


    @PostMapping("/solicitud")
    public Mono<ResponseEntity<SolicitudResponse>> tipoCambio(@RequestBody SolicitudRequest solicitudRequest) {

        return tipoCambioService.generarSolicitud(solicitudRequest)
                .map(p -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(p))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping("/tipocambio")
    public Mono<TipoCambio> nuevaSolicitudCambio(@RequestBody TipoCambio solicitud) {

        return tipoCambioService.createTipoCambio(solicitud);
    }

    @GetMapping("/tipocambio")
    public Flux<TipoCambio> tipoDeCambios() {

        return tipoCambioService.listarTipoCambio();
    }

    @GetMapping("/solicitud")
    public Flux<SolicitudResponse> listaSolicitudes() {
        return tipoCambioService.verSolicitudes();
    }

}
