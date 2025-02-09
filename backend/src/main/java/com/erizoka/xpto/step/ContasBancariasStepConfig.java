package com.erizoka.xpto.step;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.erizoka.xpto.entity.Cliente;
import com.erizoka.xpto.entity.Conta;
import com.erizoka.xpto.processor.ContasBancariasProcessor;
import com.erizoka.xpto.writer.ContasBancariasWriterConfig;

@Configuration
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

	@Bean
	Step contasBancariasStep(
			JdbcCursorItemReader<Cliente> itemReader, 
			ItemProcessor<Cliente, Conta> itemProcessor, 
			ContasBancariasWriterConfig itemWriter) {
		
		return new StepBuilder("contasBancariasStep", jobRepository)
				.<Cliente, Conta>chunk(1, transactionManager)
				.reader(itemReader)
				.processor(itemProcessor)
				.writer(itemWriter)
				.listener(new StepExecutionListener() {
                    @Override
                    public void beforeStep(@SuppressWarnings("null") StepExecution stepExecution) {
                        JobParameters jobParameters = stepExecution.getJobParameters();
						String clienteId = jobParameters.getString("clienteId");

						itemReader.setPreparedStatementSetter((ps) -> {
							ps.setString(1, clienteId);
						});
                    }

                    @Override
                    public ExitStatus afterStep(@SuppressWarnings("null") StepExecution stepExecution) {
                        return ExitStatus.COMPLETED;
                    }
				})
				.build();
	}
}
