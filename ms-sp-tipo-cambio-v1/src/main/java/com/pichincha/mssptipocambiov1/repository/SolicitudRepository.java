package com.pichincha.mssptipocambiov1.repository;

import com.pichincha.mssptipocambiov1.model.Solicitud;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudRepository extends CrudRepository<Solicitud, Long> {
}
