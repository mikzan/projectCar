package com.betacom.carjpa.dto;

public class MarcaModelloDTO {

	private Integer idMarcaModello;
    private String marca;
	private String modello;

	public MarcaModelloDTO() {
		super();
	}
	public MarcaModelloDTO(Integer idMarcaModello, String marca, String modello) {
		super();
		this.idMarcaModello = idMarcaModello;
		this.marca = marca;
		this.modello = modello;
	
	}
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

	@Override
	public String toString() {
		return "MarcaModelloDTO [idMarcaModello=" + idMarcaModello + ", marca=" + marca + ", modello=" + modello
				+ "]";
	}
	
	
}
