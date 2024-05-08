package com.pichincha.mssptipocambiov1.service.impl;

import com.pichincha.mssptipocambiov1.model.TipoCambio;
import com.pichincha.mssptipocambiov1.repository.TipoCambioRepository;
import com.pichincha.mssptipocambiov1.service.TipoCambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoCambioServiceImpl implements TipoCambioService {

    @Autowired
    TipoCambioRepository tipoCambioRepository;

    @Override
    public TipoCambio createTipoCambio(TipoCambio tipoCambio) {
        return tipoCambioRepository.save(tipoCambio);
    }

    @Override
    public Optional<TipoCambio> buscarTipoCambioPorId(Long id) {
        return tipoCambioRepository.findById(id);
    }

    @Override
    public TipoCambio actualizarTipoCambio(TipoCambio tipoCambio) {
        return tipoCambioRepository.save(tipoCambio);
    }

    @Override
    public List<TipoCambio> listarTipoCambio() {
        return (List<TipoCambio>) tipoCambioRepository.findAll();
    }

    @Override
    public void eliminarTipoCambio(Long id) {
        tipoCambioRepository.deleteById(id);
    }

    @Override
    public TipoCambio buscarPorMoneda(String monedaBase) {
        return tipoCambioRepository.findByMonedaBase(monedaBase);
    }
}
