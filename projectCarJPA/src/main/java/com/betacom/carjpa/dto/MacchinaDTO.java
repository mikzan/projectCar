package com.betacom.carjpa.dto;

public class MacchinaDTO {

	private Integer idMacchina;
	private Integer numeroPorte;
	private String targa;
	private Integer cc;
	private VeicoloDTO veicolo;
	
	public MacchinaDTO() {
		super();
	}
	public MacchinaDTO(Integer idMacchina, Integer numeroPorte, String targa, Integer cc) {
		super();
		this.idMacchina = idMacchina;
		this.numeroPorte = numeroPorte;
		this.targa = targa;
		this.cc = cc;
	}
	public MacchinaDTO(Integer idMacchina, Integer numeroPorte, String targa, Integer cc, VeicoloDTO veicolo) {
		super();
		this.idMacchina = idMacchina;
		this.numeroPorte = numeroPorte;
		this.targa = targa;
		this.cc = cc;
		this.veicolo = veicolo;
	}
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
	public VeicoloDTO getVeicolo() {
		return veicolo;
	}
	public void setVeicolo(VeicoloDTO veicolo) {
		this.veicolo = veicolo;
	}
	@Override
	public String toString() {
		return "MacchinaDTO [idMacchina=" + idMacchina + ", numeroPorte=" + numeroPorte + ", targa=" + targa + ", cc="
				+ cc + ", veicolo=" + veicolo + "]";
	}

	
}
