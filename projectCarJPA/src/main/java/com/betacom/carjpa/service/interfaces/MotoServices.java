package com.betacom.carjpa.service.interfaces;

import java.util.List;

import com.betacom.carjpa.dto.MotoDTO;
import com.betacom.carjpa.exception.CarException;
import com.betacom.carjpa.request.MotoRequest;

public interface MotoServices {

	Integer create(MotoRequest request) throws CarException;
	
	List<MotoDTO> list();
}
