package com.pichincha.mssptipocambiov1.expose;

import com.pichincha.mssptipocambiov1.expose.response.SolicitudResponse;
import com.pichincha.mssptipocambiov1.model.Auditoria;
import com.pichincha.mssptipocambiov1.model.Solicitud;
import com.pichincha.mssptipocambiov1.model.TipoCambio;
import com.pichincha.mssptipocambiov1.service.AuditoriaService;
import com.pichincha.mssptipocambiov1.service.SolicitudService;
import com.pichincha.mssptipocambiov1.service.TipoCambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/v1/sp")
@RestController
public class TipoCambioController {

    @Autowired
    private SolicitudService solicitudService;

    @Autowired
    private TipoCambioService tipoCambioService;

    @Autowired
    private AuditoriaService auditoriaService;

    @PostMapping("/solicitud")
    public Solicitud nuevaSolicitudCambio(@RequestBody Solicitud solicitud) {

        return solicitudService.createSolicitud(solicitud);
    }

    @GetMapping("/solicitud/{id}")
    public Optional<Solicitud> nuevaSolicitudCambio(@PathVariable Long id) {

        return solicitudService.buscarTipoCambioPorId(id);
    }

    @PutMapping("/solicitud")
    public Solicitud actualizarSolicitudCambio(@RequestBody Solicitud solicitud) {

        return solicitudService.actualizarSolicitud(solicitud);
    }

    @GetMapping("/solicitud")
    public List<Solicitud> listaSolicitudes() {

        return solicitudService.verSolicitudes();
    }

    //tipoCambio

    @PostMapping("/tipocambio")
    public TipoCambio nuevaSolicitudCambio(@RequestBody TipoCambio solicitud) {

        return tipoCambioService.createTipoCambio(solicitud);
    }

    @GetMapping("/tipocambio/{id}")
    public Optional<TipoCambio> obtenerTipoCambio(@PathVariable Long id) {

        return tipoCambioService.buscarTipoCambioPorId(id);
    }

    @GetMapping("/tipocambio")
    public List<TipoCambio> tipoDeCambios() {

        return tipoCambioService.listarTipoCambio();
    }

    @PutMapping("/tipocambio")
    public TipoCambio actualizarTipoCambio(@RequestBody TipoCambio solicitud) {

        return tipoCambioService.actualizarTipoCambio(solicitud);
    }

    @GetMapping("/tipocambio/moneda/{monedaBase}")
    public TipoCambio obtenerTipoCambio(@PathVariable String monedaBase) {

        return tipoCambioService.buscarPorMoneda(monedaBase);
    }

    //Auditoria

    @GetMapping("/auditoria")
    public List<Auditoria> auditoria() {

        return auditoriaService.listarAuditoria();
    }


}
