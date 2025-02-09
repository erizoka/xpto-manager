package com.erizoka.xpto.data.vo;

import com.erizoka.xpto.enuns.TipoConta;

public class ContaVO {

	private Integer id;
	
	private TipoConta tipo;

	private Double limite;
	
	private ClienteVO cliente;

	public ContaVO() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}

	public Double getLimite() {
		return limite;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}

	public ClienteVO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}
}
