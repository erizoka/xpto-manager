package com.erizoka.xpto.processor;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;

import com.erizoka.xpto.dominio.DemonstrativoOrçamentário;
import com.erizoka.xpto.dominio.DemonstrativoOrçamentárioItem;
import com.erizoka.xpto.entity.ArquivoFullDemonstrativoOrçamentário;

//Job que cadastra os gastos no banco de lançamentos, também gerando um relatório no console
public class DemonstrativoOrcamentarioProcessor implements 
ItemProcessor<ArquivoFullDemonstrativoOrçamentário, ArquivoFullDemonstrativoOrçamentário>{

	Map<Integer, DemonstrativoOrçamentário> orcamentos = new HashMap<>();
	
	@Override
	public ArquivoFullDemonstrativoOrçamentário process(ArquivoFullDemonstrativoOrçamentário item) throws Exception {
		Integer codigoDespesa = item.getCodigoDespesa();

		DemonstrativoOrçamentário orcamento = orcamentos.get(codigoDespesa);
        if (orcamento == null) {
            orcamento = new DemonstrativoOrçamentário();
            orcamento.setCodigoDespesa(codigoDespesa);
            orcamento.setDescricaoDespesa(item.getDescricaoDespesa());
            orcamento.setTotalDespesas(0.0);
            orcamentos.put(codigoDespesa, orcamento);
        }

        DemonstrativoOrçamentárioItem orcamentoItem = new DemonstrativoOrçamentárioItem();
        orcamentoItem.setDescricaoItem(item.getDescricaoItem());
        orcamentoItem.setData(item.getData());
        orcamentoItem.setValor(item.getValor());

        orcamento.getItems().add(orcamentoItem);
        orcamento.setTotalDespesas(orcamento.getTotalDespesas() + item.getValor());
        
        // Retorna item original para ser persistido no bancos
        return item;
    }

    public Collection<DemonstrativoOrçamentário> getOrcamentos() {
        return orcamentos.values();
    }
}
