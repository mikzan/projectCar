package com.betacom.carjpa.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.carjpa.dto.VeicoloDTO;
import com.betacom.carjpa.request.MacchinaRequest;
import com.betacom.carjpa.request.VeicoloRequest;
import com.betacom.carjpa.response.ResponseBase;
import com.betacom.carjpa.response.ResponseList;
import com.betacom.carjpa.service.interfaces.VeicoloServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/rest/veicolo")
public class VeicoloController {

	@Autowired
	Logger log;
	
	@Autowired
	VeicoloServices veicoloServ;
	
	@GetMapping("/list")
	public ResponseList<VeicoloDTO> list() {
		log.debug("Lista");
		ResponseList<VeicoloDTO> response = new ResponseList<VeicoloDTO>();
		response.setRc(true);
		try {
			response.setDati(veicoloServ.list());
			response.setMsg("Lista veicoli");
		} catch (Exception e) {
			log.error(e.getMessage());
			response.setRc(false);
			response.setMsg(e.getMessage());
		}
		return response;
	}
	
	@Transactional(rollbackFor = Exception.class)
	@PostMapping("/update")
	public ResponseBase update(@RequestBody (required = true) VeicoloRequest request) {
		log.debug("update: " + request);
		ResponseBase response = new ResponseBase();
		response.setRc(true);
		try {
			veicoloServ.update(request);
			response.setMsg("veicolo aggiornato");	
			
		} catch (Exception e) {
			log.error(e.getMessage());
			response.setRc(false);
			response.setMsg(e.getMessage());
		}
		return response;
	}
	

	
}
