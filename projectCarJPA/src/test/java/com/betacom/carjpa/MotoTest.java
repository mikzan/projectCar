package com.betacom.carjpa;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.betacom.carjpa.controller.MacchinaController;
import com.betacom.carjpa.controller.MotoController;
import com.betacom.carjpa.dto.MacchinaDTO;
import com.betacom.carjpa.dto.MotoDTO;
import com.betacom.carjpa.model.Categoria;
import com.betacom.carjpa.model.Colore;
import com.betacom.carjpa.model.KeyID;
import com.betacom.carjpa.model.MarcaModello;
import com.betacom.carjpa.model.Moto;
import com.betacom.carjpa.model.TipoAlimentazione;
import com.betacom.carjpa.model.TipoVeicolo;
import com.betacom.carjpa.repository.ICategoriaRepository;
import com.betacom.carjpa.repository.IColoreRepository;
import com.betacom.carjpa.repository.IMarcaModelloRepository;
import com.betacom.carjpa.repository.ITipoAlimentazione;
import com.betacom.carjpa.repository.ITipoVeicoloRepository;
import com.betacom.carjpa.request.MacchinaRequest;
import com.betacom.carjpa.request.MotoRequest;
import com.betacom.carjpa.response.ResponseBase;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MotoTest {

	@Autowired
	Logger log;
	
	@Autowired
	IColoreRepository colorRepo;
	@Autowired
	ICategoriaRepository catRepo;
	@Autowired
	IMarcaModelloRepository mmRepo;
	@Autowired
	ITipoAlimentazione alimRepo;
	@Autowired
	ITipoVeicoloRepository tipoRepo;
	
	@Autowired
	MotoController controller;
	
	@Test
	@Order(1)
	public void createElementi() {
		Colore colore = new Colore();
		colore.setNome("Blu");
		colorRepo.save(colore);
		Categoria categoria = new Categoria();
		categoria.setNome("Strada");
		categoria.setKeyID(new KeyID("moto", 1));
		catRepo.save(categoria);
		MarcaModello mm = new MarcaModello();
		mm.setMarca("marca1");
		mm.setModello("modello1");
		mmRepo.save(mm);
		TipoAlimentazione alim = new TipoAlimentazione();
		alim.setKeyID(new KeyID("moto", 1));
		alim.setNome("benzina");
		alimRepo.save(alim);
		TipoVeicolo tipo = new TipoVeicolo();
		tipo.setNome("moto");
		tipoRepo.save(tipo);
	}
	
	@Test
	@Order(2)
	public void createMoto() {
		MotoRequest m = new MotoRequest();
		m.setCategoria("moto-1");
		m.setMarcaModello(2);
		m.setColore(2);
		m.setTipoAlimentazione(1);
		m.setTipoVeicolo("moto");
		m.setNumeroRuote(2);
		m.setCc(1000);
		m.setTarga("AA11111");
		ResponseBase response = new ResponseBase();
		response = controller.create(m);
		log.debug(response.getMsg());
		Assertions.assertThat(response.getRc()).isEqualTo(true);
		
		List<MotoDTO> lista = controller.list().getDati();
		Assertions.assertThat(lista.size()).isEqualTo(1);
	}
	
	@Test
	@Order(2)
	public void createErrorMoto() {
		MotoRequest m = new MotoRequest();
		m.setCategoria("moto-1");
		m.setMarcaModello(2);
		m.setColore(2);
		m.setTipoAlimentazione(1);
		m.setTipoVeicolo("moto");
		m.setNumeroRuote(2);
		m.setCc(1000);
		m.setTarga("AA111AA");
		ResponseBase response = new ResponseBase();
		response = controller.create(m);
		log.debug(response.getMsg());
		Assertions.assertThat(response.getRc()).isEqualTo(false);
		
	}
}
