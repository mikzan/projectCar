package com.betacom.carjpa.dto;

import com.betacom.carjpa.model.KeyID;

public class TipoAlimentazioneDTO {

	private KeyID keyID;
    private String nome;

	public TipoAlimentazioneDTO() {
		super();
	}
	public TipoAlimentazioneDTO(KeyID keyID, String nome) {
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
		return "TipoAlimentazioneDTO [keyID=" + keyID + ", nome=" + nome + "]";
	}
	
	
}
