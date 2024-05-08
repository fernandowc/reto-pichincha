package com.pichincha.mssptipocambiov1.repository;

import com.pichincha.mssptipocambiov1.model.TipoCambio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCambioRepository extends CrudRepository<TipoCambio, Long> {


    TipoCambio findByMonedaBase(String monedaBase);


}
