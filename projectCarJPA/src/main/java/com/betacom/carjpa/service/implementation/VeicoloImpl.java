package com.betacom.carjpa.service.implementation;

import static com.betacom.carjpa.utilities.Utility.buildBiciDTO;
import static com.betacom.carjpa.utilities.Utility.buildMacchinaDTO;
import static com.betacom.carjpa.utilities.Utility.buildMotoDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.carjpa.dto.CategoriaDTO;
import com.betacom.carjpa.dto.ColoreDTO;
import com.betacom.carjpa.dto.MarcaModelloDTO;
import com.betacom.carjpa.dto.TipoAlimentazioneDTO;
import com.betacom.carjpa.dto.TipoVeicoloDTO;
import com.betacom.carjpa.dto.VeicoloDTO;
import com.betacom.carjpa.exception.CarException;
import com.betacom.carjpa.model.Bici;
import com.betacom.carjpa.model.Categoria;
import com.betacom.carjpa.model.Colore;
import com.betacom.carjpa.model.KeyID;
import com.betacom.carjpa.model.Macchina;
import com.betacom.carjpa.model.MarcaModello;
import com.betacom.carjpa.model.Moto;
import com.betacom.carjpa.model.TipoAlimentazione;
import com.betacom.carjpa.model.TipoVeicolo;
import com.betacom.carjpa.model.Veicolo;
import com.betacom.carjpa.repository.IBiciRepository;
import com.betacom.carjpa.repository.ICategoriaRepository;
import com.betacom.carjpa.repository.IColoreRepository;
import com.betacom.carjpa.repository.IMacchinaRepository;
import com.betacom.carjpa.repository.IMarcaModelloRepository;
import com.betacom.carjpa.repository.IMotoRepository;
import com.betacom.carjpa.repository.ITipoAlimentazione;
import com.betacom.carjpa.repository.ITipoVeicoloRepository;
import com.betacom.carjpa.repository.IVeicoloRepository;
import com.betacom.carjpa.request.VeicoloRequest;
import com.betacom.carjpa.service.interfaces.MsgServices;
import com.betacom.carjpa.service.interfaces.VeicoloServices;

@Service
public class VeicoloImpl implements VeicoloServices {
	
	@Autowired
	Logger log;
	
	@Autowired
	IVeicoloRepository veicoloRep;
	@Autowired
	ITipoVeicoloRepository tipoVRep;
	@Autowired
	ITipoAlimentazione tipoARep;
	@Autowired
	IColoreRepository coloreRep;
	@Autowired
	IMarcaModelloRepository marcaModRep;
	@Autowired
	ICategoriaRepository catRep;
	@Autowired
	IMacchinaRepository macchinaRep;
	@Autowired
	IMotoRepository motoRep;
	@Autowired
	IBiciRepository biciRep;
	
	@Autowired
	private MsgServices msgServ;
	
	@Override
	public void create(VeicoloRequest request) throws CarException {
		log.debug("Creazione: " + request);
		Veicolo veicolo = new Veicolo();
		veicolo.setTipoVeicolo(findTipoVeicolo(request.getTipoVeicolo()));
		checkRuote(request, veicolo);
		checkTipoAlimentazione(request, veicolo);
		checkColore(request, veicolo);
		checkMarcaModello(request, veicolo);
		checkCategoria(request, veicolo);
		//controllo null dei 3 tipi di veicolo
		if (request.getIdMacchina() != null) {
			Optional<Macchina> macchina = macchinaRep.findById(request.getIdMacchina());
			if (macchina.isEmpty()) {
				throw new CarException("Nessuna Macchina corrispondente");
			}
			veicolo.setMacchina(macchina.get());
		} else if (request.getIdMoto() != null) {
			Optional<Moto> moto = motoRep.findById(request.getIdMoto());
			if (moto.isEmpty()) {
				throw new CarException("Nessuna Moto corrispondente");
			}
			veicolo.setMoto(moto.get());
		} else if (request.getIdBici() != null) {
			Optional<Bici> bici = biciRep.findById(request.getIdBici());
			if (bici.isEmpty()) {
				throw new CarException("Nessuna Bici corrispondente");
			}
			veicolo.setBici(bici.get());
			} else {
				throw new CarException(msgServ.getMessaggio("no_couple"));
			}	
		veicoloRep.save(veicolo);
	}

	@Override
	public List<VeicoloDTO> list() {
		log.debug("Lista per ID");
		List<Veicolo> listaVeicolo = veicoloRep.findAll();
		return listaVeicolo.stream()
				.map(veicolo -> new VeicoloDTO(
						veicolo.getId(),
						veicolo.getNumeroRuote(),
						new TipoVeicoloDTO(veicolo.getTipoVeicolo().getIdTipoVeicolo(), veicolo.getTipoVeicolo().getNome()),
						new TipoAlimentazioneDTO(veicolo.getTipoAlimentazione().getKeyID(),veicolo.getTipoAlimentazione().getNome()),
						new ColoreDTO(veicolo.getColore().getIdColore(),veicolo.getColore().getNome()),
						new MarcaModelloDTO(veicolo.getMarcaModello().getIdMarcaModello(),veicolo.getMarcaModello().getMarca(),veicolo.getMarcaModello().getModello()),
						new CategoriaDTO(veicolo.getCategoria().getKeyID(), veicolo.getCategoria().getNome()),
						veicolo.getDataInserimento(),
						veicolo.getMacchina()==null ? null : buildMacchinaDTO(veicolo.getMacchina()),
						veicolo.getMoto()== null ? null : buildMotoDTO(veicolo.getMoto()), 
						veicolo.getBici()== null? null : buildBiciDTO(veicolo.getBici())))
				.collect(Collectors.toList());
	}
	
	@Override
	public void delete(VeicoloRequest request) throws CarException {
		Veicolo veicolo = new Veicolo();
		if (request.getId() != null) {
			Optional<Veicolo> ricerca= veicoloRep.findById(request.getId());
			if (ricerca.isEmpty()) throw new CarException(msgServ.getMessaggio("no_delete"));
			veicolo = ricerca.get();
		} else if (request.getIdMacchina() != null) {
			Optional<Macchina> ricerca = macchinaRep.findById(request.getIdMacchina());
			if (ricerca.isEmpty()) throw new CarException(msgServ.getMessaggio("no_delete"));
			veicolo = ricerca.get().getVeicolo();
		} else if (request.getIdMoto() != null) {
			Optional<Moto> ricerca = motoRep.findById(request.getIdMoto());
			if (ricerca.isEmpty()) throw new CarException(msgServ.getMessaggio("no_delete"));
			veicolo = ricerca.get().getVeicolo();
		} else if (request.getIdBici() != null) {
			Optional<Bici> ricerca = biciRep.findById(request.getIdBici());
			if (ricerca.isEmpty()) throw new CarException(msgServ.getMessaggio("no_delete"));
			veicolo = ricerca.get().getVeicolo();
		} else {
			throw new CarException(msgServ.getMessaggio("no_delete"));
		}
		veicoloRep.delete(veicolo);
	}
	
	@Override
	public void update(VeicoloRequest request) throws CarException {
		log.debug("Update: " + request);
		Veicolo veicolo;
		boolean rc = false;
		Optional<Veicolo> v = veicoloRep.findById(request.getId());
		if (v.isEmpty()) {
			throw new CarException(msgServ.getMessaggio("no_veicolo"));
		}
		veicolo = v.get();
		try {rc = checkRuote(request, veicolo); } catch (CarException e) {}
		try {rc = checkTipoAlimentazione(request, veicolo); } catch (CarException e) {}
		try {rc = checkColore(request, veicolo);} catch (CarException e) {}
		try {rc = checkMarcaModello(request, veicolo);} catch (CarException e) {}
		try {rc = checkCategoria(request, veicolo);} catch (CarException e) {}
			if (rc) {
				veicoloRep.save(veicolo);
			} else {
				throw new CarException(msgServ.getMessaggio("no_update"));
			}
	}

	private KeyID keySplit(String str) {
		String[] keySplit = str.split("-");
		KeyID key = new KeyID();
		key.setTipo(keySplit[0]);
		key.setId(Integer.parseInt(keySplit[1]));
		return key;
	}
		
	private TipoVeicolo findTipoVeicolo(String str) throws CarException {
		Optional<TipoVeicolo> tipoVeicolo = null;
		try {
			tipoVeicolo = tipoVRep.findById(Integer.parseInt(str));
		} catch (Exception e) {
			tipoVeicolo = tipoVRep.findByNome(str);
		}
		if (tipoVeicolo.isEmpty()) {
			throw new CarException(msgServ.getMessaggio("no_type"));
		}
		return tipoVeicolo.get();
	}

	private boolean checkRuote(VeicoloRequest request, Veicolo veicolo) throws CarException {
		boolean rc = true;
		if (request.getNumeroRuote() == null) {
			rc=false;
			throw new CarException(msgServ.getMessaggio("no_wheel"));
		}
		veicolo.setNumeroRuote(request.getNumeroRuote());
		return rc;
	}
	
	private boolean checkTipoAlimentazione(VeicoloRequest request, Veicolo veicolo) throws CarException {
		boolean rc = true;
		if (request.getTipoAlimentazione() == null) {
			rc = false;
			throw new CarException(msgServ.getMessaggio("no_fuel"));
		}
		Optional<TipoAlimentazione> tipoA = tipoARep.findById(new KeyID(request.getTipoVeicolo(), request.getTipoAlimentazione()));
		// tipoA = tipoARep.findById(keySplit(request.getTipoAlimentazione()));
		veicolo.setTipoAlimentazione(tipoA.get());
		return rc;
	}
	
	private boolean checkColore(VeicoloRequest request, Veicolo veicolo) throws CarException {
		boolean rc = true;
		if(request.getColore() == null) {
			rc = false;
			throw new CarException(msgServ.getMessaggio("no_color"));
		}
		Optional<Colore> colore = coloreRep.findById(request.getColore());
 		veicolo.setColore(colore.get());
		return rc;
	}
	
	private boolean checkMarcaModello(VeicoloRequest request, Veicolo veicolo) throws CarException {
		boolean rc = true;
		if(request.getMarcaModello() == null) {
			rc = false;
			throw new CarException(msgServ.getMessaggio("no_model"));
		}
		Optional<MarcaModello> marcaModello = marcaModRep.findById(request.getMarcaModello());
		veicolo.setMarcaModello(marcaModello.get());
		return rc;
	}
	
	private boolean checkCategoria(VeicoloRequest request, Veicolo veicolo) throws CarException {
		boolean rc = true;
		if(request.getCategoria() == null) {
			rc = false;
			throw new CarException(msgServ.getMessaggio("no_cat"));
		}
		Optional<Categoria> cat = catRep.findById(keySplit(request.getCategoria()));
		veicolo.setCategoria(cat.get());
		return rc;
	}
	
}
