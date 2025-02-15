package com.betacom.carjpa.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.carjpa.dto.BiciDTO;
import com.betacom.carjpa.exception.CarException;
import com.betacom.carjpa.request.BiciRequest;
import com.betacom.carjpa.request.VeicoloRequest;
import com.betacom.carjpa.response.ResponseBase;
import com.betacom.carjpa.response.ResponseList;
import com.betacom.carjpa.service.interfaces.BiciServices;
import com.betacom.carjpa.service.interfaces.VeicoloServices;

@RestController
@RequestMapping("/rest/bici")
public class BiciController {


	@Autowired
	Logger log;
	
	@Autowired
	BiciServices biciServ;
	
	@Autowired
	VeicoloServices veicoloServ;
	
	@GetMapping("/list")
	public ResponseList<BiciDTO> list() {
		log.debug("Lista");
		ResponseList<BiciDTO> response = new ResponseList<BiciDTO>();
		response.setRc(true);
		try {
			response.setDati(biciServ.list());
			response.setMsg("Lista Bici");
		} catch (Exception e) {
			log.error(e.getMessage());
			response.setRc(false);
			response.setMsg(e.getMessage());
		}
		return response;
	}
	
	@Transactional(rollbackFor = CarException.class)
	@PostMapping("/create")
	public ResponseBase create(@RequestBody (required = true) BiciRequest request) {
		log.debug("create: " + request);
		ResponseBase response = new ResponseBase();
		response.setRc(true);
		try {
			Integer id = biciServ.create(request);
			request.setIdBici(id);
			request.setTipoVeicolo("bici");
			veicoloServ.create((VeicoloRequest)request);
			response.setMsg("Macchina creata");	
			
		} catch (Exception e) {
			log.error(e.getMessage());
			response.setRc(false);
			response.setMsg(e.getMessage());
		}
		return response;
	}
	
	@Transactional(rollbackFor = CarException.class)
	@PostMapping("/delete")
	public ResponseBase delete(@RequestBody (required = true) BiciRequest request) {
		log.debug("delete: " + request);
		ResponseBase response = new ResponseBase();
		response.setRc(true);
		try {
			veicoloServ.delete(request);
			response.setMsg("Macchina eliminata");	
			
		} catch (CarException e) {
			log.error(e.getMessage());
			response.setRc(false);
			response.setMsg(e.getMessage());
		}
		return response;
	}
}
