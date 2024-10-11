package com.erizoka.xpto.reader;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.erizoka.xpto.entity.Cliente;

@Configuration
public class ContasBancariasReader {

	@Bean
	JdbcCursorItemReader<Cliente> jdbcCursorContaBancariaReader(@Qualifier("springDataSource") DataSource datasource){
		return new JdbcCursorItemReaderBuilder<Cliente>()
				.name("jdbcCursosReader")
				.dataSource(datasource)
				.sql("SELECT * FROM cliente WHERE email = ?")
				.rowMapper(new BeanPropertyRowMapper<Cliente>(Cliente.class))
				.build();
	}
}
