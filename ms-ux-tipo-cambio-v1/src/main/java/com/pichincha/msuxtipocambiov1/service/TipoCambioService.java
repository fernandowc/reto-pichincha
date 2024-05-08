package com.pichincha.msuxtipocambiov1.service;

import com.pichincha.msuxtipocambiov1.expose.request.SolicitudRequest;
import com.pichincha.msuxtipocambiov1.expose.request.TipoCambio;
import com.pichincha.msuxtipocambiov1.expose.response.SolicitudResponse;
import com.pichincha.msuxtipocambiov1.expose.response.UserResponse;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

public interface TipoCambioService {

    Mono<SolicitudResponse> generarSolicitud(SolicitudRequest solicitudRequest);

    boolean validarUsuario(Long idUsuario);

    Mono<UserResponse> findById(Long id);
}
