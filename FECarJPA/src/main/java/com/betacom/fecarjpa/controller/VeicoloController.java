package com.betacom.fecarjpa.controller;

import java.net.URI;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.betacom.fecarjpa.response.ResponseList;

@Controller
@RequestMapping("/veicolo")
public class VeicoloController {

	@Value("${jpa.backend}")
	String backend;
	
	@Autowired
	RestTemplate rest;
	
	@Autowired
	Logger log;
	
	@GetMapping("/lista")
	public ModelAndView lista() {
		ModelAndView mav= new ModelAndView("lista");
		URI uri = UriComponentsBuilder
				.fromUriString(backend + "veicolo/list")
				.buildAndExpand().toUri();
		ResponseList<?> lista = rest.getForEntity(uri, ResponseList.class).getBody();
		log.debug("rc: " + lista.getrC());
		mav.addObject("lista",lista);
		mav.addObject("isVeicolo", true);
		mav.addObject("titolo", "Lista Veicoli");

		return mav;
	}
	

	 
}
