package com.betacom.carjpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.carjpa.model.Categoria;
import com.betacom.carjpa.model.KeyID;

public interface ICategoriaRepository extends JpaRepository<Categoria, KeyID> {
	
	Optional<Categoria> findByNome(String str);
	

}
