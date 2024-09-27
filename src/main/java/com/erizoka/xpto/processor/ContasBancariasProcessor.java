package com.erizoka.xpto.processor;

import org.springframework.batch.item.ItemProcessor;

import com.erizoka.xpto.entity.Cliente;
import com.erizoka.xpto.entity.Conta;

//Job que criou as contas bancárias com os clientes cadastrados em banco, script na pasta files
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
