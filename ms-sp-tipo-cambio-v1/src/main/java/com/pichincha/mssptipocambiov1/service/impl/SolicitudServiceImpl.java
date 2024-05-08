package com.pichincha.mssptipocambiov1.service.impl;

import com.pichincha.mssptipocambiov1.expose.response.SolicitudResponse;
import com.pichincha.mssptipocambiov1.model.Solicitud;
import com.pichincha.mssptipocambiov1.model.TipoCambio;
import com.pichincha.mssptipocambiov1.repository.SolicitudRepository;
import com.pichincha.mssptipocambiov1.repository.TipoCambioRepository;
import com.pichincha.mssptipocambiov1.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SolicitudServiceImpl implements SolicitudService {

    @Autowired
    SolicitudRepository solicitudRepository;

    @Autowired
    TipoCambioRepository tipoCambioRepository;


    @Override
    public Solicitud createSolicitud(Solicitud solicitud) {
        TipoCambio tipoCambio = tipoCambioRepository.findByMonedaBase(solicitud.getMonedaOrigen());
        return solicitudRepository.save(buildSolicitudResponse(solicitud, tipoCambio));
    }

    @Override
    public Optional<Solicitud> buscarTipoCambioPorId(Long id) {

        Solicitud solicitud = solicitudRepository.findById(id).orElse(null);
        return Optional.ofNullable(solicitud);
    }

    @Override
    public Solicitud actualizarSolicitud(Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }

    public Solicitud buildSolicitudResponse(Solicitud solicitud, TipoCambio tipoCambio) {

        return Solicitud.builder()
                .usuarioSolicitante(solicitud.getUsuarioSolicitante())
                .monto(solicitud.getMonto())
                .monedaOrigen(solicitud.getMonedaOrigen())
                .monedaDestino(solicitud.getMonedaDestino())
                .montoCambiado(solicitud.getMonto().multiply(tipoCambio.getTasaCambio()))
                .fechaProceso(solicitud.getFechaProceso())
                .build();
    }
}
