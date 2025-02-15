package com.betacom.carjpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="moto")
public class Moto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMoto;
	
	@Column(nullable = false,
			length = 7)
	private String targa;
	
	@Column(nullable = false)
	private Integer cc;
	
	@OneToOne(mappedBy = "moto")
	private Veicolo veicolo;

	public Integer getIdMoto() {
		return idMoto;
	}

	public void setIdMoto(Integer idMoto) {
		this.idMoto = idMoto;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public Integer getCc() {
		return cc;
	}

	public void setCc(Integer cc) {
		this.cc = cc;
	}

	public Veicolo getVeicolo() {
		return veicolo;
	}

	public void setVeicolo(Veicolo veicolo) {
		this.veicolo = veicolo;
	}
	
	
}
