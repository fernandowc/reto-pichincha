package com.pichincha.mssptipocambiov1.service;

import com.pichincha.mssptipocambiov1.model.Auditoria;

import java.util.List;

public interface AuditoriaService {

    Auditoria createAuditoria(Auditoria auditoria);
    List<Auditoria> listarAuditoria();
}
