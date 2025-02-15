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
@Table(name = "tipo_veicolo")
public class TipoVeicolo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_tipo_veicolo")
	private int idTipoVeicolo;
	
	@Column(nullable = false,
			length = 50,
			unique = true)
    private String nome;
	
	@OneToMany(
			mappedBy = "tipoVeicolo",
			fetch = FetchType.EAGER)
	private List<Veicolo> veicolo;
	
	public int getIdTipoVeicolo() {
		return idTipoVeicolo;
	}

	public void setIdTipoVeicolo(int idTipoVeicolo) {
		this.idTipoVeicolo = idTipoVeicolo;
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
