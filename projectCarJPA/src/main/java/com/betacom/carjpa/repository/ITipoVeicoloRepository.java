package com.betacom.carjpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.carjpa.model.TipoVeicolo;

public interface ITipoVeicoloRepository extends JpaRepository<TipoVeicolo, Integer>{

	Optional<TipoVeicolo> findByNome(String str);
	Optional<TipoVeicolo> findByIdTipoVeicolo(Integer id);
}
