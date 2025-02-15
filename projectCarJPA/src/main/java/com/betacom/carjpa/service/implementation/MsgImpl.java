package com.betacom.carjpa.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.carjpa.model.Msg;
import com.betacom.carjpa.model.MsgID;
import com.betacom.carjpa.repository.IMsgRepository;
import com.betacom.carjpa.service.interfaces.MsgServices;

@Service
public class MsgImpl implements MsgServices{

	@Autowired
	IMsgRepository msgRepo;
	
	private String language = "IT";
	
	@Override
	public String getMessaggio(String code) {
		Optional<Msg> msg = msgRepo.findById(new MsgID(language, code));
		String response = null;
		if (msg.isEmpty()) {
			response = code;
		} else {
			response = msg.get().getMessaggio();
		}
		return response;
	}

}
