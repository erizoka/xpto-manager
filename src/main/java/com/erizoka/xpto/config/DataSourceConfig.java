package com.erizoka.xpto.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

	@Bean
	DataSource springDataSource() {
		return DataSourceBuilder.create()
				.driverClassName("org.postgresql.Driver")
	            .url("jdbc:postgresql://localhost:5432/XPTO")
	            .username("postgres")
	            .password("admin")
				.build();
	}
}
