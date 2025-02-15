package com.betacom.carjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.carjpa.model.KeyID;
import com.betacom.carjpa.model.TipoAlimentazione;

public interface ITipoAlimentazione extends JpaRepository<TipoAlimentazione, KeyID>{

}
