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
@Table(name="colore")
public class Colore {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_colore")
	private Integer idColore;
	
	@Column(nullable = false,
			length = 50)
    private String nome;
	
	@OneToMany(
			mappedBy = "colore",
			fetch = FetchType.EAGER)
	private List<Veicolo> veicolo;

	

	public Integer getIdColore() {
		return idColore;
	}

	public void setIdColore(Integer idColore) {
		this.idColore = idColore;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Veicolo> getVeicolo() {
		return veicolo;
	}

	public void setVeicolo(List<Veicolo> veicolo) {
		this.veicolo = veicolo;
	}
	
	
	
}
