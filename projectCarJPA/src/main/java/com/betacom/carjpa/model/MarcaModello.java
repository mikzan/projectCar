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
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="marca_modello",
	uniqueConstraints = @UniqueConstraint(columnNames = {"marca", "modello"}))
public class MarcaModello {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_marca_modello")
	private Integer idMarcaModello;
	
	@Column(nullable = false,
			length = 50)
    private String marca;
	
	@Column(nullable = false,
			length = 50)
	private String modello;

	@OneToMany(
			mappedBy = "marcaModello",
			fetch = FetchType.EAGER)
	private List<Veicolo> veicolo;

	public Integer getIdMarcaModello() {
		return idMarcaModello;
	}

	public void setIdMarcaModello(Integer idMarcaModello) {
		this.idMarcaModello = idMarcaModello;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public List<Veicolo> getVeicolo() {
		return veicolo;
	}

	public void setVeicolo(List<Veicolo> veicolo) {
		this.veicolo = veicolo;
	}

	
}
