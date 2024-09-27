package com.erizoka.xpto.writer;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemWriter;

import com.erizoka.xpto.entity.Conta;
import com.erizoka.xpto.repository.ContasBancariasRepository;

// Job que criou as contas bancárias com os clientes cadastrados em banco, script na pasta files
public class ContasBancariasWriterConfig implements ItemWriter<Conta>{
	
	private ContasBancariasRepository repository;

	public ContasBancariasWriterConfig(ContasBancariasRepository repository) {
		this.repository = repository;
	}
	
	RepositoryItemWriter<Conta> contasBancariasWriter(){
		RepositoryItemWriter<Conta> writer = new RepositoryItemWriter<>();
		writer.setRepository(repository);
		writer.setMethodName("save");
		return writer;
	}
	
	@Override
	public void write(Chunk<? extends Conta> chunk) throws Exception {
		contasBancariasWriter().write(chunk);
	}

}
