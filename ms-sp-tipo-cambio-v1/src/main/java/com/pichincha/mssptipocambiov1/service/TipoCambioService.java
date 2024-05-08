package com.pichincha.mssptipocambiov1.service;

import com.pichincha.mssptipocambiov1.model.TipoCambio;

import java.util.List;
import java.util.Optional;

public interface TipoCambioService {

    TipoCambio createTipoCambio(TipoCambio tipoCambio);
    Optional<TipoCambio> buscarTipoCambioPorId(Long id);
    TipoCambio actualizarTipoCambio(TipoCambio tipoCambio);
    List<TipoCambio> listarTipoCambio();
    void eliminarTipoCambio(Long id);
    TipoCambio buscarPorMoneda(String monedaBase);
}
