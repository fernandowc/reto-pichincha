package com.pichincha.msuxtipocambiov1.expose;

import com.pichincha.msuxtipocambiov1.expose.request.SolicitudRequest;
import com.pichincha.msuxtipocambiov1.expose.request.TipoCambio;
import com.pichincha.msuxtipocambiov1.expose.response.SolicitudResponse;
import com.pichincha.msuxtipocambiov1.expose.response.UserResponse;
import com.pichincha.msuxtipocambiov1.service.TipoCambioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/pichincha")
@RequiredArgsConstructor
public class TipoCambioController {

    private final TipoCambioService tipoCambioService;


    @PostMapping
    public Mono<ResponseEntity<SolicitudResponse>> tipoCambio(@RequestBody SolicitudRequest solicitudRequest) {

        return tipoCambioService.generarSolicitud(solicitudRequest)
                .map(p -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(p))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
