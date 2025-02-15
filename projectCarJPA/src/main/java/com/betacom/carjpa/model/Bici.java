package com.betacom.carjpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="bici")
public class Bici {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idBici;
	
	@Column(name="pieghevole")
	private Boolean pieghevole;
	
	@Column
	private Integer numeroMarce;
	
	@ManyToOne
	@JoinColumn(name = "id_sospensioni", nullable = false)
    private Sospensioni sospensioni;
	
	@OneToOne(mappedBy = "bici")
	private Veicolo veicolo;

	public Integer getIdBici() {
		return idBici;
	}

	public void setIdBici(Integer idBici) {
		this.idBici = idBici;
	}

	public Boolean getPieghevole() {
		return pieghevole;
	}

	public void setPieghevole(Boolean pieghevole) {
		this.pieghevole = pieghevole;
	}

	public Integer getNumeroMarce() {
		return numeroMarce;
	}

	public void setNumeroMarce(Integer numeroMarce) {
		this.numeroMarce = numeroMarce;
	}

	public Sospensioni getSospensioni() {
		return sospensioni;
	}

	public void setSospensioni(Sospensioni sospensioni) {
		this.sospensioni = sospensioni;
	}

	public Veicolo getVeicolo() {
		return veicolo;
	}

	public void setVeicolo(Veicolo veicolo) {
		this.veicolo = veicolo;
	}

	
	
}
