package com.betacom.carjpa.dto;

public class TipoVeicoloDTO {

	private int idTipoVeicolo;
    private String nome;
	
	public TipoVeicoloDTO() {
		super();
	}
	public TipoVeicoloDTO(int idTipoVeicolo, String nome) {
		super();
		this.idTipoVeicolo = idTipoVeicolo;
		this.nome = nome;
	}
	public int getIdTipoVeicolo() {
		return idTipoVeicolo;
	}
	public void setIdTipoVeicolo(int idTipoVeicolo) {
		this.idTipoVeicolo = idTipoVeicolo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "TipoVeicoloDTO [idTipoVeicolo=" + idTipoVeicolo + ", nome=" + nome + "]";
	}
	
	
}
