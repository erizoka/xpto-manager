package com.erizoka.xpto.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.erizoka.xpto.entity.Cliente;
import com.erizoka.xpto.entity.Conta;

@Component
public class ContasBancariasProcessor implements ItemProcessor<Cliente, Conta>{

	@Override
	public Conta process(Cliente cliente) throws Exception {
		
		Conta conta = new Conta();
		
		conta.setClienteId(cliente.getEmail());
		conta.setFaixaSalarial(cliente.getFaixaSalarial());
		conta.definirTipoELimitePorFaixaSalarial();
		
		return conta;
	}

}
