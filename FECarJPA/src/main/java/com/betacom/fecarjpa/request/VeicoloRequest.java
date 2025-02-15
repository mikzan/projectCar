package com.betacom.fecarjpa.request;

public class VeicoloRequest {

	private Integer id;
    private Integer numeroRuote;
    private String tipoVeicolo; 
    private Integer tipoAlimentazione; 
    private Integer colore; 
    private Integer marcaModello; 
    private String categoria; 
    private String dataInserimento;
    private Integer idMacchina;
    private Integer idMoto;
    private Integer idBici;
    
	public VeicoloRequest() {
		super();
	}
	public VeicoloRequest(Integer id, Integer numeroRuote, String tipoVeicolo, Integer tipoAlimentazione,
			Integer colore, Integer marcaModello, String categoria, String dataInserimento, Integer idMacchina,
			Integer idMoto, Integer idBici) {
		super();
		this.id = id;
		this.numeroRuote = numeroRuote;
		this.tipoVeicolo = tipoVeicolo;
		this.tipoAlimentazione = tipoAlimentazione;
		this.colore = colore;
		this.marcaModello = marcaModello;
		this.categoria = categoria;
		this.dataInserimento = dataInserimento;
		this.idMacchina = idMacchina;
		this.idMoto = idMoto;
		this.idBici = idBici;
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
	public String getTipoVeicolo() {
		return tipoVeicolo;
	}
	public void setTipoVeicolo(String tipoVeicolo) {
		this.tipoVeicolo = tipoVeicolo;
	}
	public Integer getTipoAlimentazione() {
		return tipoAlimentazione;
	}
	public void setTipoAlimentazione(Integer tipoAlimentazione) {
		this.tipoAlimentazione = tipoAlimentazione;
	}
	public Integer getColore() {
		return colore;
	}
	public void setColore(Integer colore) {
		this.colore = colore;
	}
	public Integer getMarcaModello() {
		return marcaModello;
	}
	public void setMarcaModello(Integer marcaModello) {
		this.marcaModello = marcaModello;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getDataInserimento() {
		return dataInserimento;
	}
	public void setDataInserimento(String dataInserimento) {
		this.dataInserimento = dataInserimento;
	}
	public Integer getIdMacchina() {
		return idMacchina;
	}
	public void setIdMacchina(Integer idMacchina) {
		this.idMacchina = idMacchina;
	}
	public Integer getIdMoto() {
		return idMoto;
	}
	public void setIdMoto(Integer idMoto) {
		this.idMoto = idMoto;
	}
	public Integer getIdBici() {
		return idBici;
	}
	public void setIdBici(Integer idBici) {
		this.idBici = idBici;
	}
	@Override
	public String toString() {
		return "VeicoloRequest [id=" + id + ", numeroRuote=" + numeroRuote + ", tipoVeicolo=" + tipoVeicolo
				+ ", tipoAlimentazione=" + tipoAlimentazione + ", colore=" + colore + ", marcaModello=" + marcaModello
				+ ", categoria=" + categoria + ", dataInserimento=" + dataInserimento + ", idMacchina=" + idMacchina
				+ ", idMoto=" + idMoto + ", idBici=" + idBici + "]";
	}
    
    
    
    
}
