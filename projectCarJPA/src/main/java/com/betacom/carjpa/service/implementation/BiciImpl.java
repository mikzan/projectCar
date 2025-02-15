package com.betacom.carjpa.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.carjpa.dto.BiciDTO;
import com.betacom.carjpa.dto.CategoriaDTO;
import com.betacom.carjpa.dto.ColoreDTO;
import com.betacom.carjpa.dto.MarcaModelloDTO;
import com.betacom.carjpa.dto.SospensioniDTO;
import com.betacom.carjpa.dto.TipoAlimentazioneDTO;
import com.betacom.carjpa.dto.TipoVeicoloDTO;
import com.betacom.carjpa.dto.VeicoloDTO;
import com.betacom.carjpa.exception.CarException;
import com.betacom.carjpa.model.Bici;
import com.betacom.carjpa.model.Sospensioni;
import com.betacom.carjpa.repository.IBiciRepository;
import com.betacom.carjpa.repository.ISospensioniRepository;
import com.betacom.carjpa.request.BiciRequest;
import com.betacom.carjpa.service.interfaces.BiciServices;
import com.betacom.carjpa.service.interfaces.MsgServices;

@Service
public class BiciImpl implements BiciServices{

	@Autowired
	Logger log;
	
	@Autowired
	private MsgServices msgServ;
	
	@Autowired
	IBiciRepository biciRep;
	@Autowired
	ISospensioniRepository sospRep;
	
	/*
	 * private Integer numeroMarce;
	private Integer tipoSospensione;
	private Boolean pieghevole;
	 */
	
	
	@Override
	public Integer create(BiciRequest request) throws CarException {
		log.debug("Creazione: " + request);
		if (request.getNumeroMarce() == null) {
			throw new CarException(msgServ.getMessaggio("no_gear"));
		}
		if (request.getPieghevole() == null) {
			request.setPieghevole(false);
		}
		Optional<Sospensioni> sospensioni = null;
		if (request.getTipoSospensione() == null) {
			sospensioni = sospRep.findByNome("none");
		} else {
			sospensioni = sospRep.findById(request.getTipoSospensione());
		}
		Bici bici = new Bici();
		bici.setNumeroMarce(request.getNumeroMarce());
		bici.setPieghevole(request.getPieghevole());
		bici.setSospensioni(sospensioni.get());
		return biciRep.save(bici).getIdBici();
	}

	@Override
	public List<BiciDTO> list() {
		List<Bici> listaBici = biciRep.findAll();
		return listaBici.stream()
				.map(bici -> new BiciDTO(
						bici.getIdBici(),
						bici.getPieghevole(),
						bici.getNumeroMarce(),
						new SospensioniDTO(bici.getSospensioni().getIdSospensione(),bici.getSospensioni().getNome()),
						new VeicoloDTO(
								bici.getVeicolo().getId(),
								bici.getVeicolo().getNumeroRuote(),
								new TipoVeicoloDTO(bici.getVeicolo().getTipoVeicolo().getIdTipoVeicolo(), bici.getVeicolo().getTipoVeicolo().getNome()),
								new TipoAlimentazioneDTO(bici.getVeicolo().getTipoAlimentazione().getKeyID(),bici.getVeicolo().getTipoAlimentazione().getNome()),
								new ColoreDTO(bici.getVeicolo().getColore().getIdColore(),bici.getVeicolo().getColore().getNome()),
								new MarcaModelloDTO(bici.getVeicolo().getMarcaModello().getIdMarcaModello(),bici.getVeicolo().getMarcaModello().getMarca(),bici.getVeicolo().getMarcaModello().getModello()),
								new CategoriaDTO(bici.getVeicolo().getCategoria().getKeyID(), bici.getVeicolo().getCategoria().getNome()),
								bici.getVeicolo().getDataInserimento())
						))
				.collect(Collectors.toList());
	}
	
	

}
