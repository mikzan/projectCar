package com.betacom.carjpa.service.interfaces;

import java.util.List;

import com.betacom.carjpa.dto.MacchinaDTO;
import com.betacom.carjpa.exception.CarException;
import com.betacom.carjpa.request.MacchinaRequest;

public interface MacchinaServices {

	Integer create(MacchinaRequest request) throws CarException;
	
	List<MacchinaDTO> list();
}
