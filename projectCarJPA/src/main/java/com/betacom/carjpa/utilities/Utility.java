package com.betacom.carjpa.utilities;

import com.betacom.carjpa.dto.BiciDTO;
import com.betacom.carjpa.dto.MacchinaDTO;
import com.betacom.carjpa.dto.MotoDTO;
import com.betacom.carjpa.dto.SospensioniDTO;
import com.betacom.carjpa.model.Bici;
import com.betacom.carjpa.model.Macchina;
import com.betacom.carjpa.model.Moto;

public class Utility {

	public static MacchinaDTO buildMacchinaDTO (Macchina macchina) {
		return new MacchinaDTO(
				macchina.getIdMacchina(),
				macchina.getNumeroPorte(),
				macchina.getTarga(),
				macchina.getCc());
	}
	
	public static MotoDTO buildMotoDTO (Moto moto) {
		return new MotoDTO(
				moto.getIdMoto(),
				moto.getTarga(),
				moto.getCc());
	}
	
	public static BiciDTO buildBiciDTO (Bici bici) {
		return new BiciDTO(
				bici.getIdBici(),
				bici.getPieghevole(),
				bici.getNumeroMarce(),
				new SospensioniDTO(
						bici.getSospensioni().getIdSospensione(),
						bici.getSospensioni().getNome()
				));
				
	}
		
}
