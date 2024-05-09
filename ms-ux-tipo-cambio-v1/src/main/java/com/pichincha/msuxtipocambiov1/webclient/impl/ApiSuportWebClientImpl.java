package com.pichincha.msuxtipocambiov1.webclient.impl;

import com.pichincha.msuxtipocambiov1.constant.TrialsAuthConstant;
import com.pichincha.msuxtipocambiov1.expose.request.SolicitudRequest;
import com.pichincha.msuxtipocambiov1.expose.request.TipoCambio;
import com.pichincha.msuxtipocambiov1.expose.response.SolicitudResponse;
import com.pichincha.msuxtipocambiov1.webclient.ApiSuportTipoCambioWebClient;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Slf4j
@Component
@Setter
public class ApiSuportWebClientImpl implements ApiSuportTipoCambioWebClient {

    @Qualifier("apiSupportWebClient")
    private final WebClient apiSupportWebClient;


    @Override
    public Mono<SolicitudResponse> nuevaSolicitud(SolicitudRequest solicitudRequest) {
        return apiSupportWebClient.post()
                .uri(TrialsAuthConstant.URI_POST_API_SUPPORT_SOLICITUD)
                .headers(httpHeaders ->
                        httpHeaders.setContentType(MediaType.APPLICATION_JSON)
                )
                .bodyValue(SolicitudRequest.builder()
                        .usuarioSolicitante(solicitudRequest.getUsuarioSolicitante())
                        .monto(solicitudRequest.getMonto())
                        .monedaOrigen(solicitudRequest.getMonedaOrigen())
                        .monedaDestino(solicitudRequest.getMonedaDestino())
                        .fechaProceso(solicitudRequest.getFechaProceso())
                        .build())
                .retrieve()
                .bodyToMono(SolicitudResponse.class)
                .log();
    }

    @Override
    public Mono<TipoCambio> nuevoTipoCambio(TipoCambio tipoCambio) {
        return apiSupportWebClient.post()
                .uri(TrialsAuthConstant.URI_POST_API_SUPPORT_TIPO_CAMBIO)
                .headers(httpHeaders ->
                        httpHeaders.setContentType(MediaType.APPLICATION_JSON)
                )
                .bodyValue(TipoCambio.builder()
                        .monedaBase(tipoCambio.getMonedaBase())
                        .monedaDestino(tipoCambio.getMonedaDestino())
                        .tasaCambio(tipoCambio.getTasaCambio())
                        .fechaHora(tipoCambio.getFechaHora())
                        .proveedor(tipoCambio.getProveedor())
                        .build())
                .retrieve()
                .bodyToMono(TipoCambio.class)
                .log();
    }

    @Override
    public Flux<TipoCambio> listarTipoCambio() {
        return apiSupportWebClient.get()
                .uri(TrialsAuthConstant.URI_POST_API_SUPPORT_TIPO_CAMBIO)
                .headers(httpHeaders ->
                        httpHeaders.setContentType(MediaType.APPLICATION_JSON)
                )
                .retrieve()
                .bodyToFlux(TipoCambio.class)
                .log();
    }

    @Override
    public Flux<SolicitudResponse> listarSolicitudes() {
        return apiSupportWebClient.get()
                .uri(TrialsAuthConstant.URI_POST_API_SUPPORT_SOLICITUD)
                .headers(httpHeaders ->
                        httpHeaders.setContentType(MediaType.APPLICATION_JSON)
                )
                .retrieve()
                .bodyToFlux(SolicitudResponse.class)
                .log();
    }
}
