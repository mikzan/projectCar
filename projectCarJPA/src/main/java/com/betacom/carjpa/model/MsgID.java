package com.betacom.carjpa.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class MsgID {

	private String language;
	private String code;
	
	public MsgID() {
		super();
	}
	
	public MsgID(String language, String code) {
		super();
		this.language = language;
		this.code = code;
	}

	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
