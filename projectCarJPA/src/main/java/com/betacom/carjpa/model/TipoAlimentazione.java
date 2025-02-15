package com.betacom.carjpa.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tipo_alimentazione")
public class TipoAlimentazione {

	@EmbeddedId 
	private KeyID keyID;
	
	@Column(nullable = false,
			length = 50)
    private String nome;

	@OneToMany(
			mappedBy = "tipoAlimentazione",
			fetch = FetchType.EAGER)
	private List<Veicolo> veicolo;
	
	public KeyID getKeyID() {
		return keyID;
	}

	public void setKeyID(KeyID keyID) {
		this.keyID = keyID;
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
