package com.erizoka.xpto.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NovaContaComEmailJobConfig {

	private JobRepository jobRepository;

	public NovaContaComEmailJobConfig(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}

	@Bean
	Job novaContaComEmailJob(Step contasBancariasStep, Step emailBoasVindasStep) {
		return new JobBuilder("novaContaComEmailJob", jobRepository)
				.start(contasBancariasStep)
				.next(emailBoasVindasStep)
				.build();
	}
}