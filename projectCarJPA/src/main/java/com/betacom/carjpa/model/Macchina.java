package com.betacom.carjpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="macchina")
public class Macchina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMacchina;
	
	@Column(name = "numero_porte",
			nullable = false)
	private Integer numeroPorte;
	
	@Column(nullable = false,
			length = 7)
	private String targa;
	
	@Column(nullable = false)
	private Integer cc;
	
	@OneToOne(mappedBy = "macchina")
	private Veicolo veicolo;
	
	public Integer getIdMacchina() {
		return idMacchina;
	}

	public void setIdMacchina(Integer idMacchina) {
		this.idMacchina = idMacchina;
	}

	public Integer getNumeroPorte() {
		return numeroPorte;
	}

	public void setNumeroPorte(Integer numeroPorte) {
		this.numeroPorte = numeroPorte;
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
