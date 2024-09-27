package com.erizoka.xpto.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "lancamento")
public class ArquivoFullDemonstrativoOrçamentário {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "codigoNaturezaDespesa")
	private Integer codigoDespesa;
	
	@Column(name = "descricaoNaturezaDespesa")
	private String descricaoDespesa;
	
	@Column(name = "descricaoLancamento")
	private String descricaoItem;
	
	@Column(name = "dataLancamento")
	private String data;
	
	@Column(name = "valorLancamento")
	private Double valor;

	public Integer getCodigoDespesa() {
		return codigoDespesa;
	}

	public void setCodigoDespesa(Integer codigoDespesa) {
		this.codigoDespesa = codigoDespesa;
	}

	public String getDescricaoDespesa() {
		return descricaoDespesa;
	}

	public void setDescricaoDespesa(String descricaoDespesa) {
		this.descricaoDespesa = descricaoDespesa;
	}

	public String getDescricaoItem() {
		return descricaoItem;
	}

	public void setDescricaoItem(String descricaoItem) {
		this.descricaoItem = descricaoItem;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}

