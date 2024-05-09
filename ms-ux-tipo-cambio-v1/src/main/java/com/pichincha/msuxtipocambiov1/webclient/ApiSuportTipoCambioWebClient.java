package com.pichincha.msuxtipocambiov1.webclient;

import com.pichincha.msuxtipocambiov1.expose.request.SolicitudRequest;
import com.pichincha.msuxtipocambiov1.expose.request.TipoCambio;
import com.pichincha.msuxtipocambiov1.expose.response.SolicitudResponse;
import com.pichincha.msuxtipocambiov1.expose.response.UserResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ApiSuportTipoCambioWebClient {

    Mono<SolicitudResponse> nuevaSolicitud(SolicitudRequest solicitudReques);
    Mono<TipoCambio> nuevoTipoCambio(TipoCambio tipoCambio);
    Flux<TipoCambio> listarTipoCambio();
    Flux<SolicitudResponse> listarSolicitudes();
}
