package com.erizoka.xpto.reader;

import java.io.IOException;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.erizoka.xpto.entity.ArquivoFullDemonstrativoOrçamentário;

//Job que cadastra os gastos no banco de lançamentos, também gerando um relatório no console
public class ArquivoFullDemonstrativoOrcamentarioReader {
	
	private Resource[] resources;

	public Resource[] getResources() {
		return resources;
	}

	public void setResources() {
		try {
			
			resources = new PathMatchingResourcePatternResolver().getResources("file:src/main/resources/files/*");
			
			if (resources.length == 0) {
		        throw new RuntimeException("Nenhum arquivo encontrado para o padrão especificado.");
		    }
			
		} catch (IOException e) {
			throw new RuntimeException("Erro ao carregar o arquivo: ", e);
		}
	}
	
	private LineMapper<ArquivoFullDemonstrativoOrçamentário> lineMapper(){
		DefaultLineMapper<ArquivoFullDemonstrativoOrçamentário> lineMapper = new DefaultLineMapper<>();
		
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter(",");
		tokenizer.setNames("codigoDespesa", "descricaoDespesa", "descricaoItem", "data", "valor");
		
		BeanWrapperFieldSetMapper<ArquivoFullDemonstrativoOrçamentário> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(ArquivoFullDemonstrativoOrçamentário.class);
		
		lineMapper.setLineTokenizer(tokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		
		return lineMapper;
	}


    FlatFileItemReader<ArquivoFullDemonstrativoOrçamentário> flatFileItemReader() {
        FlatFileItemReader<ArquivoFullDemonstrativoOrçamentário> reader = new FlatFileItemReader<>();
        reader.setLineMapper(lineMapper());
        return reader;
    }
	

	MultiResourceItemReader<ArquivoFullDemonstrativoOrçamentário> multiResourceItemReader(
			FlatFileItemReader<ArquivoFullDemonstrativoOrçamentário> itemReader) {
		
		setResources();
		return new MultiResourceItemReaderBuilder<ArquivoFullDemonstrativoOrçamentário>()
				.name("multiResourceItemReader")
				.resources(getResources())
				.delegate(itemReader)
				.build();
	}
}