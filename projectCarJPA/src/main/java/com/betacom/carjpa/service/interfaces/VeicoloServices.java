package com.betacom.carjpa.service.interfaces;

import java.util.List;

import com.betacom.carjpa.dto.VeicoloDTO;
import com.betacom.carjpa.exception.CarException;
import com.betacom.carjpa.request.VeicoloRequest;

public interface VeicoloServices {

	void create(VeicoloRequest request) throws CarException;
	
	List<VeicoloDTO> list();
	
	void delete(VeicoloRequest request) throws CarException;
	
	void update(VeicoloRequest request) throws CarException;
}
