package com.erizoka.xpto.step;

import java.util.Collection;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.transaction.PlatformTransactionManager;

import com.erizoka.xpto.dominio.DemonstrativoOrçamentário;
import com.erizoka.xpto.entity.ArquivoFullDemonstrativoOrçamentário;
import com.erizoka.xpto.processor.DemonstrativoOrcamentarioProcessor;
import com.erizoka.xpto.writer.ArquivoFullDemonstrativoOrçamentárioWriter;

//Job que cadastra os gastos no banco de lançamentos, também gerando um relatório no console
public class DemonstrativoOrcamentarioStep {
	
	private PlatformTransactionManager transactionManager;
	private JobRepository jobRepository;
	
	public DemonstrativoOrcamentarioStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		this.jobRepository = jobRepository;
		this.transactionManager = transactionManager;
	}
	
	StepExecutionListener stepExecutionListener(DemonstrativoOrcamentarioProcessor demoProcessor) {
	    return new StepExecutionListener() {

	        @Override
	        public void beforeStep(StepExecution stepExecution) {
	            // Antes do step, nenhuma ação necessária
	        }

	        @Override
	        public ExitStatus afterStep(StepExecution stepExecution) {
	            Collection<DemonstrativoOrçamentário> relatorios = demoProcessor.getOrcamentos();
	            relatorios.forEach(item -> System.out.println(item.toString()));
	            return ExitStatus.COMPLETED;
	        }
	    };
	}
	

	DemonstrativoOrcamentarioProcessor demoProcessor() {
	    return new DemonstrativoOrcamentarioProcessor();
	}



	Step demoOrcamentarioStep(
			MultiResourceItemReader<ArquivoFullDemonstrativoOrçamentário> multiResourceItemReader,
			DemonstrativoOrcamentarioProcessor demoProcessor, 
			ArquivoFullDemonstrativoOrçamentárioWriter demoWriter) {
		
		return new StepBuilder("demoOrcamentarioStep", jobRepository)
				.<ArquivoFullDemonstrativoOrçamentário, ArquivoFullDemonstrativoOrçamentário>chunk(1, transactionManager)
				.reader(multiResourceItemReader)
				.processor(demoProcessor)
				.writer(demoWriter)
				.listener(stepExecutionListener(demoProcessor))
				.build();
	}
}
