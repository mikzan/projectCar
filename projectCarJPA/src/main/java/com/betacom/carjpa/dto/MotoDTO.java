package com.betacom.carjpa.dto;

public class MotoDTO {

	private Integer idMoto;
	private String targa;
	private Integer cc;
	private VeicoloDTO veicolo;
	
	public MotoDTO() {
		super();
	}
	public MotoDTO(Integer idMoto, String targa, Integer cc) {
		super();
		this.idMoto = idMoto;
		this.targa = targa;
		this.cc = cc;
	}
	public MotoDTO(Integer idMoto, String targa, Integer cc, VeicoloDTO veicolo) {
		super();
		this.idMoto = idMoto;
		this.targa = targa;
		this.cc = cc;
		this.veicolo = veicolo;
	}
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
	public VeicoloDTO getVeicolo() {
		return veicolo;
	}
	public void setVeicolo(VeicoloDTO veicolo) {
		this.veicolo = veicolo;
	}
	@Override
	public String toString() {
		return "MotoDTO [idMoto=" + idMoto + ", targa=" + targa + ", cc=" + cc + ", veicolo=" + veicolo + "]";
	}
	
	
}
