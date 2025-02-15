package com.betacom.carjpa.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.carjpa.dto.CategoriaDTO;
import com.betacom.carjpa.dto.ColoreDTO;
import com.betacom.carjpa.dto.MarcaModelloDTO;
import com.betacom.carjpa.dto.MotoDTO;
import com.betacom.carjpa.dto.TipoAlimentazioneDTO;
import com.betacom.carjpa.dto.TipoVeicoloDTO;
import com.betacom.carjpa.dto.VeicoloDTO;
import com.betacom.carjpa.exception.CarException;
import com.betacom.carjpa.model.Moto;
import com.betacom.carjpa.repository.IMotoRepository;
import com.betacom.carjpa.request.MotoRequest;
import com.betacom.carjpa.service.interfaces.MotoServices;
import com.betacom.carjpa.service.interfaces.MsgServices;

@Service
public class MotoImpl implements MotoServices{
	
	@Autowired
	Logger log;
	
	@Autowired
	IMotoRepository motoRep;

	@Autowired
	private MsgServices msgServ;

	@Override
	public Integer create(MotoRequest request) throws CarException {
		log.debug("Creazione: " + request);
		if (request.getCc() == null) {
			throw new CarException(msgServ.getMessaggio("no_cc"));
		}
		if (request.getTarga() == null || request.getTarga() == "") {
			throw new CarException(msgServ.getMessaggio("no_plate"));
		}
		if (!request.getTarga().matches("^[A-Za-z]{2}\\d{5}$")) {
            throw new CarException(msgServ.getMessaggio("err_plate"));
        }
		Moto moto = new Moto();
		moto.setCc(request.getCc());
		moto.setTarga(request.getTarga());
		return motoRep.save(moto).getIdMoto();
	}

	@Override
	public List<MotoDTO> list() {
		List<Moto> listaMoto = motoRep.findAll();
		return listaMoto.stream()
				.map(moto -> new MotoDTO(
						moto.getIdMoto(),
						moto.getTarga(),
						moto.getCc(),
						new VeicoloDTO(
								moto.getVeicolo().getId(),
								moto.getVeicolo().getNumeroRuote(),
								new TipoVeicoloDTO(moto.getVeicolo().getTipoVeicolo().getIdTipoVeicolo(), moto.getVeicolo().getTipoVeicolo().getNome()),
								new TipoAlimentazioneDTO(moto.getVeicolo().getTipoAlimentazione().getKeyID(),moto.getVeicolo().getTipoAlimentazione().getNome()),
								new ColoreDTO(moto.getVeicolo().getColore().getIdColore(),moto.getVeicolo().getColore().getNome()),
								new MarcaModelloDTO(moto.getVeicolo().getMarcaModello().getIdMarcaModello(),moto.getVeicolo().getMarcaModello().getMarca(),moto.getVeicolo().getMarcaModello().getModello()),
								new CategoriaDTO(moto.getVeicolo().getCategoria().getKeyID(), moto.getVeicolo().getCategoria().getNome()),
								moto.getVeicolo().getDataInserimento())
						))
				.collect(Collectors.toList());
	}

	
}
