package com.pichincha.msuxtipocambiov1.service.impl;

import com.pichincha.msuxtipocambiov1.expose.request.SolicitudRequest;
import com.pichincha.msuxtipocambiov1.expose.request.TipoCambio;
import com.pichincha.msuxtipocambiov1.expose.response.SolicitudResponse;
import com.pichincha.msuxtipocambiov1.expose.response.UserResponse;
import com.pichincha.msuxtipocambiov1.service.TipoCambioService;
import com.pichincha.msuxtipocambiov1.webclient.ApiSuportTipoCambioWebClient;
import com.pichincha.msuxtipocambiov1.webclient.GorestAuthWebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

@Service
public class TipoCambioServiceImpl implements TipoCambioService {

    @Autowired
    GorestAuthWebClient trialsAuthWebClient;

    @Autowired
    ApiSuportTipoCambioWebClient apiSuportTipoCambioWebClient;

    @Override
    public Mono<SolicitudResponse> generarSolicitud(SolicitudRequest solicitudRequest) {


        Mono<UserResponse> userResponse = findById(solicitudRequest.getId());

        Mono<SolicitudResponse> solicitudResponse = userResponse.flatMap(userEncontrado -> {
            return apiSuportTipoCambioWebClient.nuevaSolicitud(SolicitudRequest.builder()
                    .id(userEncontrado.getId())
                    .usuarioSolicitante(userEncontrado.getName())
                    .monto(solicitudRequest.getMonto())
                    .monedaOrigen(solicitudRequest.getMonedaOrigen())
                    .monedaDestino(solicitudRequest.getMonedaDestino())
                    .fechaProceso(solicitudRequest.getFechaProceso())
                    .build());
        });

        return solicitudResponse;
    }

    @Override
    public boolean validarUsuario(Long idUsuario) {

        AtomicBoolean usuarioEncontrado = new AtomicBoolean(false);

        Flux<UserResponse> listaUsuarios = trialsAuthWebClient.trialsAuth();
        return  true;
    }

    @Override
    public Mono<UserResponse> findById(Long id) {

        Flux<UserResponse> listaUsuarios = trialsAuthWebClient.trialsAuth();

        Mono<UserResponse> usuarioEncontradoMono = listaUsuarios
                .filter(userResponse -> userResponse.getId().equals(id) && userResponse.getStatus().equalsIgnoreCase("active"))
                .next();

        usuarioEncontradoMono.subscribe(usuarioEncontrado -> {
            // Haz algo con el usuario encontrado
            System.out.println("Usuario encontrado: " + usuarioEncontrado);
        }, error -> {
            // Maneja el caso en que no se encuentra ningún usuario
            System.out.println("No se encontró ningún usuario con el id: " + id);
        });

        return usuarioEncontradoMono;
    }
}
