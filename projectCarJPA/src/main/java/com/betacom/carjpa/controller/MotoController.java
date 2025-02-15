package com.betacom.carjpa.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.carjpa.dto.MotoDTO;
import com.betacom.carjpa.exception.CarException;
import com.betacom.carjpa.request.MotoRequest;
import com.betacom.carjpa.response.ResponseBase;
import com.betacom.carjpa.response.ResponseList;
import com.betacom.carjpa.service.interfaces.MotoServices;
import com.betacom.carjpa.service.interfaces.VeicoloServices;

@RestController
@RequestMapping("/rest/moto")
public class MotoController {
	
	@Autowired
	Logger log;
	
	@Autowired
	MotoServices motoServ;
	
	@Autowired
	VeicoloServices veicoloServ;
	
	@GetMapping("/list")
	public ResponseList<MotoDTO> list() {
		log.debug("Lista");
		ResponseList<MotoDTO> response = new ResponseList<MotoDTO>();
		response.setRc(true);
		try {
			response.setDati(motoServ.list());
			response.setMsg("Lista Moto");
		} catch (Exception e) {
			log.error(e.getMessage());
			response.setRc(false);
			response.setMsg(e.getMessage());
		}
		return response;
	}
	
	@Transactional(rollbackFor = CarException.class)
	@PostMapping("/create")
	public ResponseBase create(@RequestBody (required = true) MotoRequest request) {
		log.debug("create: " + request);
		ResponseBase response = new ResponseBase();
		response.setRc(true);
		try {
			Integer id = motoServ.create(request);
			request.setIdMoto(id);
			request.setTipoVeicolo("moto");
			veicoloServ.create(request);
			response.setMsg("Moto creata");	
			
		} catch (Exception e) {
			log.error(e.getMessage());
			response.setRc(false);
			response.setMsg(e.getMessage());
		}
		return response;
	}

	@Transactional(rollbackFor = CarException.class)
	@PostMapping("/delete")
	public ResponseBase delete(@RequestBody (required = true) MotoRequest request) {
		log.debug("delete: " + request);
		ResponseBase response = new ResponseBase();
		response.setRc(true);
		try {
			veicoloServ.delete(request);
			response.setMsg("Moto eliminata");	
			
		} catch (CarException e) {
			log.error(e.getMessage());
			response.setRc(false);
			response.setMsg(e.getMessage());
		}
		return response;
	}
}
