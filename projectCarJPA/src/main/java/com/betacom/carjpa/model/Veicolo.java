package com.betacom.carjpa.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "veicolo")
public class Veicolo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_veicolo")
	private Integer id;
	
	@Column(name= "numero_ruote",
			nullable = false)
	private Integer numeroRuote;
	
	@ManyToOne 
	@JoinColumn(name="id_tipo_veicolo",
			nullable = false)
	private TipoVeicolo tipoVeicolo;
	
	@ManyToOne
	@JoinColumns( {
		@JoinColumn(name = "id_alimentazione", nullable = false),
		@JoinColumn(name = "tipo_alimentazione", nullable = false) })
	private TipoAlimentazione tipoAlimentazione;
	
	@ManyToOne
	@JoinColumn(name = "id_colore", nullable = false)
    private Colore colore;
	
	@ManyToOne
	@JoinColumn(name = "id_marca_modello", nullable = false)
    private MarcaModello marcaModello;
	
	@ManyToOne
	@JoinColumns( {
		@JoinColumn(name = "id_categoria", nullable = false),
		@JoinColumn(name = "tipo_categoria", nullable = false) })
    private Categoria categoria;
	
	 @Column(name = "data_inserimento",
			 updatable = false, 
			 insertable = false, 
			 columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date dataInserimento;
	 
	 @OneToOne(cascade = CascadeType.REMOVE)
	 @JoinColumn(name="id_macchina",
			 unique = true)
	 private Macchina macchina;

	 @OneToOne(cascade = CascadeType.REMOVE)
	 @JoinColumn(name="id_moto",
			 unique = true)
	 private Moto moto;
	 
	 @OneToOne(cascade = CascadeType.REMOVE)
	 @JoinColumn(name="id_bici",
			 unique = true)
	 private Bici bici;
	 
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

	public TipoVeicolo getTipoVeicolo() {
		return tipoVeicolo;
	}

	public void setTipoVeicolo(TipoVeicolo tipoVeicolo) {
		this.tipoVeicolo = tipoVeicolo;
	}

	public TipoAlimentazione getTipoAlimentazione() {
		return tipoAlimentazione;
	}

	public void setTipoAlimentazione(TipoAlimentazione tipoAlimentazione) {
		this.tipoAlimentazione = tipoAlimentazione;
	}

	public Colore getColore() {
		return colore;
	}

	public void setColore(Colore colore) {
		this.colore = colore;
	}

	public MarcaModello getMarcaModello() {
		return marcaModello;
	}

	public void setMarcaModello(MarcaModello marcaModello) {
		this.marcaModello = marcaModello;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Date getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public Macchina getMacchina() {
		return macchina;
	}

	public void setMacchina(Macchina macchina) {
		this.macchina = macchina;
	}

	public Moto getMoto() {
		return moto;
	}

	public void setMoto(Moto moto) {
		this.moto = moto;
	}

	public Bici getBici() {
		return bici;
	}

	public void setBici(Bici bici) {
		this.bici = bici;
	}

	 
	 
}
