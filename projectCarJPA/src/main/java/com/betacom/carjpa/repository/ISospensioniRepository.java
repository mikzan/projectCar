package com.betacom.carjpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.carjpa.model.Sospensioni;

public interface ISospensioniRepository extends JpaRepository<Sospensioni, Integer>{

	Optional<Sospensioni> findByNome(String str);
}
