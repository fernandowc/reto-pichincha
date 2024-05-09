package com.pichincha.mssptipocambiov1.service.impl;

import com.pichincha.mssptipocambiov1.model.Auditoria;
import com.pichincha.mssptipocambiov1.repository.AuditoriaRepository;
import com.pichincha.mssptipocambiov1.service.AuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditoriaServiceImpl implements AuditoriaService {

    @Autowired
    AuditoriaRepository auditoriaRepository;

    @Override
    public Auditoria createAuditoria(Auditoria auditoria) {
        return auditoriaRepository.save(auditoria);
    }

    @Override
    public List<Auditoria> listarAuditoria() {
        return (List<Auditoria>) auditoriaRepository.findAll();
    }
}
