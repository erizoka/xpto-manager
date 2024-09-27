package com.erizoka.xpto.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.transaction.PlatformTransactionManager;

import com.erizoka.xpto.entity.Cliente;
import com.erizoka.xpto.entity.Conta;
import com.erizoka.xpto.processor.ContasBancariasProcessor;
import com.erizoka.xpto.writer.ContasBancariasWriterConfig;

//Job que criou as contas bancárias com os clientes cadastrados em banco, script na pasta files
public class ContasBancariasStepConfig {

	private PlatformTransactionManager transactionManager;
	private JobRepository jobRepository;
	
	public ContasBancariasStepConfig(PlatformTransactionManager transactionManager, JobRepository jobRepository) {
		this.transactionManager = transactionManager;
		this.jobRepository = jobRepository;
	}

    ContasBancariasProcessor contasBancariasProcessor() {
        return new ContasBancariasProcessor();
    }

	Step contasBancariasStep(
			JdbcCursorItemReader<Cliente> itemReader, 
			ItemProcessor<Cliente, Conta> itemProcessor, 
			ContasBancariasWriterConfig itemWriter) {
		
		return new StepBuilder("contasBancariasStep", jobRepository)
				.<Cliente, Conta>chunk(1, transactionManager)
				.reader(itemReader)
				.processor(itemProcessor)
				.writer(itemWriter)
				.build();
	}
}
