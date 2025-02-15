package com.betacom.carjpa.service.interfaces;

import java.util.List;

import com.betacom.carjpa.dto.BiciDTO;
import com.betacom.carjpa.exception.CarException;
import com.betacom.carjpa.request.BiciRequest;

public interface BiciServices {

	Integer create(BiciRequest request) throws CarException;
	
	List<BiciDTO> list();
}
