package com.betacom.carjpa.dto;

import java.util.Date;

public class VeicoloDTO {

	private Integer id;
	private Integer numeroRuote;	
	private TipoVeicoloDTO tipoVeicolo;	
	private TipoAlimentazioneDTO tipoAlimentazione;
    private ColoreDTO colore;	
    private MarcaModelloDTO marcaModello;	
    private CategoriaDTO categoria;
    private Date dataInserimento;
	private MacchinaDTO macchina;
	private MotoDTO moto;
	private BiciDTO bici;
	public VeicoloDTO() {
		super();
	}
	public VeicoloDTO(Integer id, Integer numeroRuote, TipoVeicoloDTO tipoVeicolo,
			TipoAlimentazioneDTO tipoAlimentazione, ColoreDTO colore, MarcaModelloDTO marcaModello, CategoriaDTO categoria,
			Date dataInserimento) {
		super();
		this.id = id;
		this.numeroRuote = numeroRuote;
		this.tipoVeicolo = tipoVeicolo;
		this.tipoAlimentazione = tipoAlimentazione;
		this.colore = colore;
		this.marcaModello = marcaModello;
		this.categoria = categoria;
		this.dataInserimento = dataInserimento;
	}
	public VeicoloDTO(Integer id, Integer numeroRuote, TipoVeicoloDTO tipoVeicolo,
			TipoAlimentazioneDTO tipoAlimentazione, ColoreDTO colore, MarcaModelloDTO marcaModello, CategoriaDTO categoria,
			Date dataInserimento, MacchinaDTO macchina, MotoDTO moto, BiciDTO bici) {
		super();
		this.id = id;
		this.numeroRuote = numeroRuote;
		this.tipoVeicolo = tipoVeicolo;
		this.tipoAlimentazione = tipoAlimentazione;
		this.colore = colore;
		this.marcaModello = marcaModello;
		this.categoria = categoria;
		this.dataInserimento = dataInserimento;
		this.macchina = macchina;
		this.moto = moto;
		this.bici = bici;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumeroRuote() {
		return numeroRuote;
	}
	public void setNumeroRuote(Integer numeroRuote) {
		this.numeroRuote = numeroRuote;
	}
	public TipoVeicoloDTO getTipoVeicolo() {
		return tipoVeicolo;
	}
	public void setTipoVeicolo(TipoVeicoloDTO tipoVeicolo) {
		this.tipoVeicolo = tipoVeicolo;
	}
	public TipoAlimentazioneDTO getTipoAlimentazione() {
		return tipoAlimentazione;
	}
	public void setTipoAlimentazione(TipoAlimentazioneDTO tipoAlimentazione) {
		this.tipoAlimentazione = tipoAlimentazione;
	}
	public ColoreDTO getColore() {
		return colore;
	}
	public void setColore(ColoreDTO colore) {
		this.colore = colore;
	}
	public MarcaModelloDTO getMarcaModello() {
		return marcaModello;
	}
	public void setMarcaModello(MarcaModelloDTO marcaModello) {
		this.marcaModello = marcaModello;
	}
	public CategoriaDTO getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
	}
	public Date getDataInserimento() {
		return dataInserimento;
	}
	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}
	public MacchinaDTO getMacchina() {
		return macchina;
	}
	public void setMacchina(MacchinaDTO macchina) {
		this.macchina = macchina;
	}
	public MotoDTO getMoto() {
		return moto;
	}
	public void setMoto(MotoDTO moto) {
		this.moto = moto;
	}
	public BiciDTO getBici() {
		return bici;
	}
	public void setBici(BiciDTO bici) {
		this.bici = bici;
	}
	@Override
	public String toString() {
		return "VeicoloDTO [id=" + id + ", numeroRuote=" + numeroRuote + ", tipoVeicolo=" + tipoVeicolo
				+ ", tipoAlimentazione=" + tipoAlimentazione + ", colore=" + colore + ", marcaModello=" + marcaModello
				+ ", categoria=" + categoria + ", dataInserimento=" + dataInserimento + ", macchina=" + macchina
				+ ", moto=" + moto + ", bici=" + bici + "]";
	}
	
		
	
}
