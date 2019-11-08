package net.javaguides.usermanagement.model;

public class Imovel {
	private int id;
	private boolean disponivel;
	private boolean alugado;
	private	boolean vendido;
	private String estado;
	private	String cidade;
	private	String bairro;
	private String rua;
	private String numero;
	private String complemento;
	private String cep;
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public boolean isAlugado() {
		return alugado;
	}

	public void setAlugado(boolean alugado) {
		this.alugado = alugado;
	}

	public boolean isVendido() {
		return vendido;
	}

	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public boolean getDisponivel() {
		return disponivel;
	}

	public int setId() {
		return id;
	}
	
	public int getId() {
		return id;
	}

	public void marcarComoAlugado() {
		this.alugado = true;
	}
	
	public void marcarComoDisponivel() {
		this.disponivel = true;
	}
	
	public void marcarComoVendido() {
		this.vendido = true;
	}
	
	public Imovel(int id, Boolean disponivel, Boolean alugado, Boolean vendido, String estado, String cidade, String bairro, String rua, String numero, String complemento, String cep) {
		this.id = id;
		this.disponivel = disponivel;
		this.alugado = alugado;
		this.vendido = vendido;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
	}
	
	public Imovel(Boolean disponivel, Boolean alugado, Boolean vendido, String estado, String cidade, String bairro, String rua, String numero, String complemento, String cep) {
		this.disponivel = disponivel;
		this.alugado = alugado;
		this.vendido = vendido;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
	}
}
