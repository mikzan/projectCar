package com.betacom.carjpa.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.carjpa.dto.MacchinaDTO;
import com.betacom.carjpa.exception.CarException;
import com.betacom.carjpa.request.MacchinaRequest;
import com.betacom.carjpa.request.VeicoloRequest;
import com.betacom.carjpa.response.ResponseBase;
import com.betacom.carjpa.response.ResponseList;
import com.betacom.carjpa.service.interfaces.MacchinaServices;
import com.betacom.carjpa.service.interfaces.VeicoloServices;

@RestController
@RequestMapping("/rest/macchina")
public class MacchinaController {

	@Autowired
	Logger log;
	
	@Autowired
	MacchinaServices macchinaServ;
	
	@Autowired
	VeicoloServices veicoloServ;
	
	@GetMapping("/list")
	public ResponseList<MacchinaDTO> list() {
		log.debug("Lista");
		ResponseList<MacchinaDTO> response = new ResponseList<MacchinaDTO>();
		response.setRc(true);
		try {
			response.setDati(macchinaServ.list());
			response.setMsg("Lista macchine");
		} catch (Exception e) {
			log.error(e.getMessage());
			response.setRc(false);
			response.setMsg(e.getMessage());
		}
		return response;
	}
	
	@Transactional(rollbackFor = Exception.class)
	@PostMapping("/create")
	public ResponseBase create(@RequestBody (required = true) MacchinaRequest request) {
		log.debug("create: " + request);
		ResponseBase response = new ResponseBase();
		response.setRc(true);
		try {
			Integer id = macchinaServ.create(request);
			request.setIdMacchina(id);
			request.setTipoVeicolo("macchina");
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
	public ResponseBase delete(@RequestBody (required = true) MacchinaRequest request) {
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
