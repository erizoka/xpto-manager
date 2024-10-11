package com.erizoka.xpto.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.transaction.PlatformTransactionManager;

import com.erizoka.xpto.entity.NovaContaCliente;

@Configuration
public class EmailBoasVindasStepConfig {
    
    private PlatformTransactionManager transactionManager;
	private JobRepository jobRepository;

    public EmailBoasVindasStepConfig(PlatformTransactionManager transactionManager, JobRepository jobRepository) {
        this.transactionManager = transactionManager;
        this.jobRepository = jobRepository;
    }

    @Bean
    Step emailBoasVindasStep(
        ItemReader<NovaContaCliente> itemReader,
        ItemProcessor<NovaContaCliente, SimpleMailMessage> emailProcessor,
        ItemWriter<SimpleMailMessage> enviarEmailBoasVindasWriter){

            return new StepBuilder("emailBoasVindasStep", jobRepository)
                .<NovaContaCliente, SimpleMailMessage>chunk(1, transactionManager)
                .reader(itemReader)
                .processor(emailProcessor)
                .writer(enviarEmailBoasVindasWriter)
                .build();
    }
}
