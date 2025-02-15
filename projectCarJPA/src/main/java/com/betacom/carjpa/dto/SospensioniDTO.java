package com.betacom.carjpa.dto;

public class SospensioniDTO {

	private Integer idSospensione;
    private String nome;
    
	public SospensioniDTO() {
		super();
	}
	public SospensioniDTO(Integer idSospensione, String nome) {
		super();
		this.idSospensione = idSospensione;
		this.nome = nome;
	}
	public Integer getIdSospensione() {
		return idSospensione;
	}
	public void setIdSospensione(Integer idSospensione) {
		this.idSospensione = idSospensione;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "SospensioniDTO [idSospensione=" + idSospensione + ", nome=" + nome + "]";
	}
    
	
    
}
