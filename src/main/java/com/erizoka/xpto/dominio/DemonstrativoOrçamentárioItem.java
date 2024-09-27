package com.erizoka.xpto.dominio;

public class DemonstrativoOrçamentárioItem {

	private String descricaoItem;

	private String data;

	private Double valor;

	public DemonstrativoOrçamentárioItem() {}
	
	public DemonstrativoOrçamentárioItem(String descricaoItem, String data, Double valor) {
		this.descricaoItem = descricaoItem;
		this.data = data;
		this.valor = valor;
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

	@Override
	public String toString() {
		return "\n		[" + data + "] " + descricaoItem + " - R$" + valor;
	}
}

