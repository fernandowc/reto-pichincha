package com.pichincha.msuxtipocambiov1.webclient.impl;

import com.pichincha.msuxtipocambiov1.constant.TrialsAuthConstant;
import com.pichincha.msuxtipocambiov1.expose.request.SolicitudRequest;
import com.pichincha.msuxtipocambiov1.expose.response.SolicitudResponse;
import com.pichincha.msuxtipocambiov1.webclient.ApiSuportTipoCambioWebClient;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
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
                .uri(TrialsAuthConstant.URI_POST_API_SUPPORT_AUTH)
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
}
