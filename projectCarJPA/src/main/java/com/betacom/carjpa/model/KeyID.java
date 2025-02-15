package com.betacom.carjpa.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class KeyID {

	private String tipo;
	private Integer id;
	
	public KeyID(String tipo, Integer id) {
		super();
		this.tipo = tipo;
		this.id = id;
	}

	public KeyID() {
		super();
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
