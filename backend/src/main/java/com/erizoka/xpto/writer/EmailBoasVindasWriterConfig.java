package com.erizoka.xpto.writer;

import org.springframework.batch.item.mail.SimpleMailMessageItemWriter;
import org.springframework.batch.item.mail.builder.SimpleMailMessageItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class EmailBoasVindasWriterConfig {
    
    @Bean
	SimpleMailMessageItemWriter enviarEmailBoasVindasWriter(JavaMailSender mailSender) {
		return new SimpleMailMessageItemWriterBuilder()
				.mailSender(mailSender)
				.build();
	}
}
