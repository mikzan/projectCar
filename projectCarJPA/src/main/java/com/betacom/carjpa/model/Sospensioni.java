package com.betacom.carjpa.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "sospensioni")
public class Sospensioni {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSospensione;
	
	@Column(nullable = false,
			length = 50)
    private String nome;

	@OneToMany(
			mappedBy = "sospensioni",
			fetch = FetchType.EAGER)
	private List<Bici> bicis;

	public Integer getIdSospensione() {
		return idSospensione;
	}

	public void setIdSospensione(Integer idSospensione) {
		this.idSospensione = idSospensione;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Bici> getBicis() {
		return bicis;
	}

	public void setBicis(List<Bici> bicis) {
		this.bicis = bicis;
	}
	
	
	
}
