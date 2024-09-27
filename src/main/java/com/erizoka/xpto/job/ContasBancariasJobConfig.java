package com.erizoka.xpto.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;

//Job que criou as contas bancárias com os clientes cadastrados em banco, script na pasta files
public class ContasBancariasJobConfig {

	private JobRepository jobRepository;

	public ContasBancariasJobConfig(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}

	Job contasBancariasJob(Step contasBancariasStep) {
		return new JobBuilder("contasBancariasJob", jobRepository)
				.start(contasBancariasStep)
				.incrementer(new RunIdIncrementer())
				.build();
	}
}