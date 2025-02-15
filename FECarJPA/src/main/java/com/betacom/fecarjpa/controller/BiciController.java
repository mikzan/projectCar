package com.betacom.fecarjpa.controller;

import java.net.URI;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.betacom.fecarjpa.request.BiciRequest;
import com.betacom.fecarjpa.response.ResponseBase;
import com.betacom.fecarjpa.response.ResponseList;

@Controller
@RequestMapping("/bici")
public class BiciController {

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
				.fromUriString(backend + "bici/list")
				.buildAndExpand().toUri();
		ResponseList<?> lista = rest.getForEntity(uri, ResponseList.class).getBody();
		log.debug("rc: " + lista.getrC());
		mav.addObject("lista",lista);
		mav.addObject("isBici", true);
		mav.addObject("titolo", "Lista Bici");
		return mav;
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam Integer id) {
		
		BiciRequest request = new BiciRequest();
		request.setIdMacchina(id);
		log.debug("id :" + id);
		URI uri = UriComponentsBuilder
				.fromUriString(backend + "bici/delete")
				.buildAndExpand().toUri();
		ResponseBase r = rest.postForEntity(uri, request, ResponseBase.class).getBody();
		log.debug(r.getMsg());

		return "redirect:lista";
	}
	 
}
