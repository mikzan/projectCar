package com.betacom.fecarjpa.dto;

public class ColoreDTO {

	private Integer idColore;
    private String nome;

	public ColoreDTO() {
		super();
	}
	public ColoreDTO(Integer idColore, String nome) {
		super();
		this.idColore = idColore;
		this.nome = nome;

	}
	public Integer getIdColore() {
		return idColore;
	}
	public void setIdColore(Integer idColore) {
		this.idColore = idColore;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "ColoreDTO [idColore=" + idColore + ", nome=" + nome + "]";
	}
	
	
	
}
