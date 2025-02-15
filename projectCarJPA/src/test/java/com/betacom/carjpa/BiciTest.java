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

import com.betacom.carjpa.controller.BiciController;
import com.betacom.carjpa.dto.BiciDTO;
import com.betacom.carjpa.model.Categoria;
import com.betacom.carjpa.model.Colore;
import com.betacom.carjpa.model.KeyID;
import com.betacom.carjpa.model.MarcaModello;
import com.betacom.carjpa.model.Sospensioni;
import com.betacom.carjpa.model.TipoAlimentazione;
import com.betacom.carjpa.model.TipoVeicolo;
import com.betacom.carjpa.repository.ICategoriaRepository;
import com.betacom.carjpa.repository.IColoreRepository;
import com.betacom.carjpa.repository.IMarcaModelloRepository;
import com.betacom.carjpa.repository.ISospensioniRepository;
import com.betacom.carjpa.repository.ITipoAlimentazione;
import com.betacom.carjpa.repository.ITipoVeicoloRepository;
import com.betacom.carjpa.request.BiciRequest;
import com.betacom.carjpa.response.ResponseBase;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BiciTest {

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
	ISospensioniRepository sospRepo;
	
	@Autowired
	BiciController controller;
	
	@Test
	@Order(1)
	public void createElementi() {
		Colore colore = new Colore();
		colore.setNome("Bianca");
		colorRepo.save(colore);
		Categoria categoria = new Categoria();
		categoria.setNome("MTB");
		categoria.setKeyID(new KeyID("bici", 1));
		catRepo.save(categoria);
		MarcaModello mm = new MarcaModello();
		mm.setMarca("marca2");
		mm.setModello("modello2");
		mmRepo.save(mm);
		TipoAlimentazione alim = new TipoAlimentazione();
		alim.setKeyID(new KeyID("bici", 1));
		alim.setNome("elettrica");
		alimRepo.save(alim);
		TipoVeicolo tipo = new TipoVeicolo();
		tipo.setNome("bici");
		tipoRepo.save(tipo);
		Sospensioni sospensioni = new Sospensioni();
		sospensioni.setNome("ammortizzata");
		sospRepo.save(sospensioni);
	}
	
	@Test
	@Order(2)
	public void createBici() {
		BiciRequest bici = new BiciRequest();
		bici.setCategoria("macchina-1");
		bici.setMarcaModello(3);
		bici.setColore(3);
		bici.setTipoAlimentazione(1);
		bici.setTipoVeicolo("bici");
		bici.setNumeroRuote(2);
		bici.setNumeroMarce(7);
		bici.setPieghevole(true);
		bici.setTipoSospensione(1);
		ResponseBase response = new ResponseBase();
		response = controller.create(bici);
		Assertions.assertThat(response.getRc()).isEqualTo(true);
		
		List<BiciDTO> lista = controller.list().getDati();
		Assertions.assertThat(lista.size()).isEqualTo(1);
	}
}
