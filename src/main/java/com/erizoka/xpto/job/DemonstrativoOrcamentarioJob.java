package com.erizoka.xpto.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;

//Job que cadastra os gastos no banco de lançamentos, também gerando um relatório no console
public class DemonstrativoOrcamentarioJob {

	private JobRepository jobRepository;
	
	public DemonstrativoOrcamentarioJob(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}

	Job demoOrcamentarioJob(Step demoOrcamentarioStep) {
		return new JobBuilder("demoOrcamentarioJob", jobRepository)
					.start(demoOrcamentarioStep)
					.incrementer(new RunIdIncrementer())
					.build();
	}
}

