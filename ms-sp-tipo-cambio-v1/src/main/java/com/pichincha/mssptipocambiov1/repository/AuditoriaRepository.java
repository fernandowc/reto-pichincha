package com.pichincha.mssptipocambiov1.repository;

import com.pichincha.mssptipocambiov1.model.Auditoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriaRepository extends CrudRepository<Auditoria, Long> {

}
