package com.betacom.fecarjpa.dto;

public class CategoriaDTO {

	private KeyID keyID;
    private String nome;

	public CategoriaDTO() {
		super();
	}
	public CategoriaDTO(KeyID keyID, String nome) {
		super();
		this.keyID = keyID;
		this.nome = nome;
	}
	public KeyID getKeyID() {
		return keyID;
	}
	public void setKeyID(KeyID keyID) {
		this.keyID = keyID;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "CategoriaDTO [keyID=" + keyID + ", nome=" + nome + "]";
	}
	
	
}
