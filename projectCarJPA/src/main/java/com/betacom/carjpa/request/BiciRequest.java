package com.betacom.carjpa.request;

public class BiciRequest extends VeicoloRequest {

	private Integer numeroMarce;
	private Integer tipoSospensione;
	private Boolean pieghevole;
	
	public BiciRequest() {
		super();
	}
	public BiciRequest(Integer numeroMarce, Integer tipoSospensione, Boolean pieghevole) {
		super();
		this.numeroMarce = numeroMarce;
		this.tipoSospensione = tipoSospensione;
		this.pieghevole = pieghevole;
	}
	public Integer getNumeroMarce() {
		return numeroMarce;
	}
	public void setNumeroMarce(Integer numeroMarce) {
		this.numeroMarce = numeroMarce;
	}
	public Integer getTipoSospensione() {
		return tipoSospensione;
	}
	public void setTipoSospensione(Integer tipoSospensione) {
		this.tipoSospensione = tipoSospensione;
	}
	public Boolean getPieghevole() {
		return pieghevole;
	}
	public void setPieghevole(Boolean pieghevole) {
		this.pieghevole = pieghevole;
	}
	@Override
	public String toString() {
		return "BiciRequest [numeroMarce=" + numeroMarce + ", tipoSospensione=" + tipoSospensione + ", pieghevole="
				+ pieghevole + "]";
	}
	
	
}
