package com.betacom.carjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.carjpa.model.Moto;

public interface IMotoRepository extends JpaRepository<Moto, Integer> {

}
