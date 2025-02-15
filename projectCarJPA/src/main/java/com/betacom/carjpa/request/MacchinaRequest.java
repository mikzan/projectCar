package com.betacom.carjpa.request;

public class MacchinaRequest extends VeicoloRequest {

	private Integer numeroPorte;
	private String targa;
	private Integer cc;
	
	public MacchinaRequest() {
		super();
	}
	public MacchinaRequest(Integer numeroPorte, String targa, Integer cc) {
		super();
		this.numeroPorte = numeroPorte;
		this.targa = targa;
		this.cc = cc;
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
	@Override
	public String toString() {
		return "MacchinaRequest [numeroPorte=" + numeroPorte + ", targa=" + targa + ", cc=" + cc + "]";
	}

	
}
