package com.pichincha.mssptipocambiov1.service;

import com.pichincha.mssptipocambiov1.expose.response.SolicitudResponse;
import com.pichincha.mssptipocambiov1.model.Solicitud;

import java.util.List;
import java.util.Optional;

public interface SolicitudService {

    Solicitud createSolicitud(Solicitud solicitud);

    Optional<Solicitud> buscarTipoCambioPorId(Long id);
    Solicitud actualizarSolicitud(Solicitud solicitud);

    List<Solicitud> verSolicitudes();
}
