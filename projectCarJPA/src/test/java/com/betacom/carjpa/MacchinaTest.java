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
import com.betacom.carjpa.dto.MacchinaDTO;
import com.betacom.carjpa.model.Categoria;
import com.betacom.carjpa.model.Colore;
import com.betacom.carjpa.model.KeyID;
import com.betacom.carjpa.model.MarcaModello;
import com.betacom.carjpa.model.TipoAlimentazione;
import com.betacom.carjpa.model.TipoVeicolo;
import com.betacom.carjpa.repository.ICategoriaRepository;
import com.betacom.carjpa.repository.IColoreRepository;
import com.betacom.carjpa.repository.IMarcaModelloRepository;
import com.betacom.carjpa.repository.ITipoAlimentazione;
import com.betacom.carjpa.repository.ITipoVeicoloRepository;
import com.betacom.carjpa.request.MacchinaRequest;
import com.betacom.carjpa.response.ResponseBase;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MacchinaTest {

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
	MacchinaController controller;
	
	@Test
	@Order(1)
	public void createElementi() {
		Colore colore = new Colore();
		colore.setNome("Giallo");
		colorRepo.save(colore);
		Categoria categoria = new Categoria();
		categoria.setNome("Suv");
		categoria.setKeyID(new KeyID("macchina", 1));
		catRepo.save(categoria);
		MarcaModello mm = new MarcaModello();
		mm.setMarca("marca");
		mm.setModello("modello");
		mmRepo.save(mm);
		TipoAlimentazione alim = new TipoAlimentazione();
		alim.setKeyID(new KeyID("macchina", 1));
		alim.setNome("benzina");
		alimRepo.save(alim);
		TipoVeicolo tipo = new TipoVeicolo();
		tipo.setNome("macchina");
		tipoRepo.save(tipo);
	}
	
	@Test
	@Order(2)
	public void createMacchina() {
		MacchinaRequest macchina = new MacchinaRequest();
		macchina.setCategoria("macchina-1");
		macchina.setMarcaModello(1);
		macchina.setColore(1);
		macchina.setTipoAlimentazione(1);
		macchina.setTipoVeicolo("macchina");
		macchina.setNumeroRuote(4);
		macchina.setNumeroPorte(3);
		macchina.setCc(1000);
		macchina.setTarga("AA111AA");
		ResponseBase response = new ResponseBase();
		response = controller.create(macchina);
		Assertions.assertThat(response.getRc()).isEqualTo(true);
		
		List<MacchinaDTO> lista = controller.list().getDati();
		Assertions.assertThat(lista.size()).isEqualTo(1);
	}
	
	@Test
	@Order(3)
	public void createErrorMacchina() {
		MacchinaRequest macchina = new MacchinaRequest();
		macchina.setCategoria("macchina-1");
		macchina.setMarcaModello(1);
		macchina.setColore(1);
		macchina.setTipoAlimentazione(1);
		macchina.setTipoVeicolo("macchina");
		macchina.setNumeroRuote(4);
		macchina.setNumeroPorte(3);
		macchina.setCc(1000);
		macchina.setTarga("AA11111");
		ResponseBase response = new ResponseBase();
		response = controller.create(macchina);
		Assertions.assertThat(response.getRc()).isEqualTo(false);
	}
		
}
