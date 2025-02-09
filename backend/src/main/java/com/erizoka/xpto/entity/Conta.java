package com.erizoka.xpto.entity;

import com.erizoka.xpto.enuns.TipoConta;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

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
	
	@OneToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "email")
    private Cliente cliente;

	public Conta() {}
	
	public Conta(Integer id, TipoConta tipo, Double limite, Cliente cliente) {
		this.id = id;
		this.tipo = tipo;
		this.limite = limite;
		this.cliente = cliente;
	}

	public void definirTipoELimitePorFaixaSalarial() {
        this.tipo = TipoConta.obterTipoPorFaixaSalarial(this.cliente.getFaixaSalarial());
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
