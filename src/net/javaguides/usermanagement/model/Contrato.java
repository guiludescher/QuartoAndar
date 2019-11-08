package net.javaguides.usermanagement.model;

/**
 * User.java
 * This is a model class represents a User entity
 *
 */
public class Contrato {
	protected int id;
	protected int idImovel;
	protected String idCliente;
	protected int valor;
	protected long dataInicio;
	protected long dataFim;
	protected int multa;
	
	public Contrato() {
	}
	
	public Contrato(int idImovel, String idCliente, int valor, long dataInicio, long dataFim, int multa) {
		super();
		this.idImovel = idImovel;
		this.idCliente = idCliente;
		this.valor = valor;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.multa = multa;		
	}

	public Contrato(int id, int idImovel, String idCliente, int valor, long dataInicio, long dataFim, int multa) {
		super();
		this.id = id;
		this.idImovel = idImovel;
		this.idCliente = idCliente;
		this.valor = valor;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.multa = multa;		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdImovel() {
		return idImovel;
	}

	public void setIdImovel(int idImovel) {
		this.idImovel = idImovel;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public long getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(long dataInicio) {
		this.dataInicio = dataInicio;
	}

	public long getDataFim() {
		return dataFim;
	}

	public void setDataFim(long dataFim) {
		this.dataFim = dataFim;
	}

	public int getMulta() {
		return multa;
	}

	public void setMulta(int multa) {
		this.multa = multa;
	}
	
	
}
