package com.betacom.carjpa.request;

public class MotoRequest extends VeicoloRequest {

	private String targa;
	private Integer cc;
	
	public MotoRequest() {
		super();
	}

	public MotoRequest(String targa, Integer cc) {
		super();
		this.targa = targa;
		this.cc = cc;
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
		return "MotoRequest [targa=" + targa + ", cc=" + cc + "]";
	}
	
		
}
