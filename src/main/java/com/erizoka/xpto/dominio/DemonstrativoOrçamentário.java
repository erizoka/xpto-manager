package com.erizoka.xpto.dominio;

import java.util.ArrayList;
import java.util.List;

public class DemonstrativoOrçamentário {
	
	private Integer codigoDespesa;

	private String descricaoDespesa;
	
	private List<DemonstrativoOrçamentárioItem> items = new ArrayList<>();

	private Double totalDespesas;

	public DemonstrativoOrçamentário(Integer codigoDespesa, String descricaoDespesa,
			List<DemonstrativoOrçamentárioItem> items, Double totalDespesa) {
		this.codigoDespesa = codigoDespesa;
		this.descricaoDespesa = descricaoDespesa;
		this.items = items;
		this.totalDespesas = totalDespesa;
	}

	public DemonstrativoOrçamentário() {}

	public DemonstrativoOrçamentário(Integer codigoDespesa, String descricaoDespesa) {
		this.codigoDespesa = codigoDespesa;
		this.descricaoDespesa = descricaoDespesa;
	}

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
	
	public List<DemonstrativoOrçamentárioItem> getItems() {
		return items;
	}

	public void setItems(List<DemonstrativoOrçamentárioItem> items) {
		this.items = items;
	}

	public Double getTotalDespesas() {
		return totalDespesas;
	}

	public void setTotalDespesas(Double totalDespesas) {
		this.totalDespesas = totalDespesas;
	}

	@Override
	public String toString() {
		return "---- Demonstrativo orçamentário ---- \n"
				+ "[" + codigoDespesa + "] " + descricaoDespesa + " - R$" + totalDespesas
				+ items + "\n";
	}
}
