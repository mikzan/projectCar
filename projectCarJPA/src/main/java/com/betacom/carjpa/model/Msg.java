package com.betacom.carjpa.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="messaggi_sistema")
public class Msg {

	@EmbeddedId
	private MsgID msgID;
	
	private String messaggio;

	public MsgID getMsgID() {
		return msgID;
	}

	public void setMsgID(MsgID msgID) {
		this.msgID = msgID;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}
	
	
}
