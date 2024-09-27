package com.erizoka.xpto.reader;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.erizoka.xpto.entity.Cliente;

//Job que criou as contas bancárias com os clientes cadastrados em banco, script na pasta files
public class ContasBancariasReader {

	JdbcCursorItemReader<Cliente> jdbcCursorReader(@Qualifier("springDataSource") DataSource datasource){
		return new JdbcCursorItemReaderBuilder<Cliente>()
				.name("jdbcCursosReader")
				.dataSource(datasource)
				.sql("SELECT * FROM cliente")
				.rowMapper(new BeanPropertyRowMapper<Cliente>(Cliente.class))
				.build();
	}
}
