package com.erizoka.xpto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class PropsConfig {

	@Bean
	static PropertySourcesPlaceholderConfigurer config() {
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		FileSystemResource resource = new FileSystemResource("C:/temp/data/xpto/application.properties");
		configurer.setLocation(resource);
		return configurer;
	}
}
