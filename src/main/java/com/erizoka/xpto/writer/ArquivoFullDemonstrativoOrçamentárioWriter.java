package com.erizoka.xpto.writer;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemWriter;

import com.erizoka.xpto.entity.ArquivoFullDemonstrativoOrçamentário;
import com.erizoka.xpto.repository.ArquivoFullDemonstrativoOrçamentárioRepository;

//Job que cadastra os gastos no banco de lançamentos, também gerando um relatório no console
public class ArquivoFullDemonstrativoOrçamentárioWriter implements ItemWriter<ArquivoFullDemonstrativoOrçamentário>{
	
	private ArquivoFullDemonstrativoOrçamentárioRepository repository;

	public ArquivoFullDemonstrativoOrçamentárioWriter(ArquivoFullDemonstrativoOrçamentárioRepository repository) {
		this.repository = repository;
	}
	

	RepositoryItemWriter<ArquivoFullDemonstrativoOrçamentário> demoOrcamentarioWriter(){
		RepositoryItemWriter<ArquivoFullDemonstrativoOrçamentário> writer = new RepositoryItemWriter<>();
		writer.setRepository(repository);
		writer.setMethodName("save");
		return writer;
	}

	@Override
	public void write(Chunk<? extends ArquivoFullDemonstrativoOrçamentário> chunk) throws Exception {
		demoOrcamentarioWriter().write(chunk);
	}
}
