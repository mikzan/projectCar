package com.betacom.carjpa.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.carjpa.dto.CategoriaDTO;
import com.betacom.carjpa.dto.ColoreDTO;
import com.betacom.carjpa.dto.MacchinaDTO;
import com.betacom.carjpa.dto.MarcaModelloDTO;
import com.betacom.carjpa.dto.TipoAlimentazioneDTO;
import com.betacom.carjpa.dto.TipoVeicoloDTO;
import com.betacom.carjpa.dto.VeicoloDTO;
import com.betacom.carjpa.exception.CarException;
import com.betacom.carjpa.model.Macchina;
import com.betacom.carjpa.repository.IMacchinaRepository;
import com.betacom.carjpa.request.MacchinaRequest;
import com.betacom.carjpa.service.interfaces.MacchinaServices;
import com.betacom.carjpa.service.interfaces.MsgServices;

@Service
public class MacchinaImpl implements MacchinaServices {
	
	@Autowired
	Logger log;
	
	@Autowired
	IMacchinaRepository macchinaRep;

	@Autowired
	private MsgServices msgServ;

	
	@Override
	public Integer create(MacchinaRequest request) throws CarException {
		log.debug("Creazione: " + request);
		if (request.getNumeroPorte() == null) {
			throw new CarException(msgServ.getMessaggio("no_door"));
		}
		if (request.getCc() == null) {
			throw new CarException(msgServ.getMessaggio("no_cc"));
		}
		if (request.getTarga() == null || request.getTarga() == "") {
			throw new CarException(msgServ.getMessaggio("no_plate"));
		}
		if (!request.getTarga().matches("^[A-Za-z]{2}\\d{3}[A-Za-z]{2}$")) {
            throw new CarException(msgServ.getMessaggio("err_plate"));
        }
		Macchina macchina = new Macchina();
		macchina.setNumeroPorte(request.getNumeroPorte());
		macchina.setCc(request.getCc());
		macchina.setTarga(request.getTarga());
		return macchinaRep.save(macchina).getIdMacchina();
		
	}

	@Override
	public List<MacchinaDTO> list() {
		List<Macchina> listaMacchina = macchinaRep.findAll();
		return listaMacchina.stream()
				.map(macchina -> new MacchinaDTO(
						macchina.getIdMacchina(),
						macchina.getNumeroPorte(),
						macchina.getTarga(),
						macchina.getCc(),
						new VeicoloDTO(
								macchina.getVeicolo().getId(),
								macchina.getVeicolo().getNumeroRuote(),
								new TipoVeicoloDTO(macchina.getVeicolo().getTipoVeicolo().getIdTipoVeicolo(), macchina.getVeicolo().getTipoVeicolo().getNome()),
								new TipoAlimentazioneDTO(macchina.getVeicolo().getTipoAlimentazione().getKeyID(),macchina.getVeicolo().getTipoAlimentazione().getNome()),
								new ColoreDTO(macchina.getVeicolo().getColore().getIdColore(),macchina.getVeicolo().getColore().getNome()),
								new MarcaModelloDTO(macchina.getVeicolo().getMarcaModello().getIdMarcaModello(),macchina.getVeicolo().getMarcaModello().getMarca(),macchina.getVeicolo().getMarcaModello().getModello()),
								new CategoriaDTO(macchina.getVeicolo().getCategoria().getKeyID(), macchina.getVeicolo().getCategoria().getNome()),
								macchina.getVeicolo().getDataInserimento())
						))
				.collect(Collectors.toList());
	}

}
