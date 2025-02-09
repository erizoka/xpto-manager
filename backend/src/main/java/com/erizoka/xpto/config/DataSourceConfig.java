package com.erizoka.xpto.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfig {
	
	 	@Value("${spring.datasource.url}")
	    private String dbUrl;

	    @Value("${spring.datasource.username}")
	    private String username;

	    @Value("${spring.datasource.password}")
	    private String password;

	    @Value("${spring.datasource.driver-class-name}")
	    private String driverClassName;

	    @Primary
	    @Bean
	    DataSource springDataSource() {
	        return DataSourceBuilder.create()
	                .url(dbUrl)
	                .username(username)
	                .password(password)
	                .driverClassName(driverClassName)
	                .build();
	    }
}
