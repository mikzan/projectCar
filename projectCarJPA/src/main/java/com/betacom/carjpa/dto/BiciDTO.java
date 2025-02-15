package com.betacom.carjpa.dto;

public class BiciDTO {

	private Integer idBici;
	private Boolean pieghevole;
	private Integer numeroMarce;	
    private SospensioniDTO sospensioni;
	private VeicoloDTO veicolo;
	
	public BiciDTO() {
		super();
	}
	public BiciDTO(Integer idBici, Boolean pieghevole, Integer numeroMarce, SospensioniDTO sospensioni) {
		super();
		this.idBici = idBici;
		this.pieghevole = pieghevole;
		this.numeroMarce = numeroMarce;
		this.sospensioni = sospensioni;
	}

	public BiciDTO(Integer idBici, Boolean pieghevole, Integer numeroMarce, SospensioniDTO sospensioni, VeicoloDTO veicolo) {
		super();
		this.idBici = idBici;
		this.pieghevole = pieghevole;
		this.numeroMarce = numeroMarce;
		this.sospensioni = sospensioni;
		this.veicolo = veicolo;
	}
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
	public SospensioniDTO getSospensioni() {
		return sospensioni;
	}
	public void setSospensioni(SospensioniDTO sospensioni) {
		this.sospensioni = sospensioni;
	}
	public VeicoloDTO getVeicolo() {
		return veicolo;
	}
	public void setVeicolo(VeicoloDTO veicolo) {
		this.veicolo = veicolo;
	}
	@Override
	public String toString() {
		return "BiciDTO [idBici=" + idBici + ", pieghevole=" + pieghevole + ", numeroMarce=" + numeroMarce
				+ ", sospensioni=" + sospensioni + ", veicolo=" + veicolo + "]";
	}
	
	
	
}
