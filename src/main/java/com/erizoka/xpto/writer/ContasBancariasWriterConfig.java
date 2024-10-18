package com.erizoka.xpto.writer;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.erizoka.xpto.entity.Conta;
import com.erizoka.xpto.repository.ContasBancariasRepository;

@Configuration
public class ContasBancariasWriterConfig implements ItemWriter<Conta>{
	
	private ContasBancariasRepository repository;

	public ContasBancariasWriterConfig(ContasBancariasRepository repository) {
		this.repository = repository;
	}
	
	@Bean
	RepositoryItemWriter<Conta> contasBancariasWriter(){
		RepositoryItemWriter<Conta> writer = new RepositoryItemWriter<>();
		writer.setRepository(repository);
		writer.setMethodName("save");
		return writer;
	}
	
	@SuppressWarnings("null")
	@Override
	public void write(Chunk<? extends Conta> chunk) throws Exception {
		contasBancariasWriter().write(chunk);
	}

}

