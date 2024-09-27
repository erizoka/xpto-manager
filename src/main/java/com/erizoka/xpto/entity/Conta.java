package com.erizoka.xpto.entity;

import com.erizoka.xpto.enuns.TipoConta;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "conta")
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "tipo")
	private TipoConta tipo;
	
	@Column(name = "limite")
	private Double limite;
	
	@Column(name = "cliente_id")
	private String clienteId;
	
	@Transient
	@JsonIgnore
	private Double faixaSalarial;

	public Conta(Integer id, TipoConta tipo, Double limite, String clienteId) {
		this.id = id;
		this.tipo = tipo;
		this.limite = limite;
		this.clienteId = clienteId;
	}

	public Conta() {}
	
	public void definirTipoELimitePorFaixaSalarial() {
        this.tipo = TipoConta.obterTipoPorFaixaSalarial(this.faixaSalarial);
        this.limite = this.tipo.getLimite();
    }

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

	public String getClienteId() {
		return clienteId;
	}

	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}

	public Double getFaixaSalarial() {
		return faixaSalarial;
	}

	public void setFaixaSalarial(Double faixaSalarial) {
		this.faixaSalarial = faixaSalarial;
	}
}
