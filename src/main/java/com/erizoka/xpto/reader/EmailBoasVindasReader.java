package com.erizoka.xpto.reader;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import com.erizoka.xpto.entity.Cliente;
import com.erizoka.xpto.entity.Conta;
import com.erizoka.xpto.entity.NovaContaCliente;
import com.erizoka.xpto.enuns.TipoConta;

@Configuration
public class EmailBoasVindasReader {
    
    @Bean
	JdbcCursorItemReader<NovaContaCliente> jdbcCursorEmailBoasVindasReader(@Qualifier("springDataSource") DataSource datasource){
		return new JdbcCursorItemReaderBuilder<NovaContaCliente>()
				.name("jdbcCursosReader")
				.dataSource(datasource)
				.sql("SELECT * FROM cliente c join conta c2 on (c.email = c2.cliente_id) WHERE c.email = ?")
				.rowMapper(rowMapper())
				.build();
	}

    private RowMapper<NovaContaCliente> rowMapper() {
        return new RowMapper<NovaContaCliente>() {

            @SuppressWarnings("null")
			@Override
            public NovaContaCliente mapRow(ResultSet rs, int rowNum) throws SQLException {
                Cliente cliente = new Cliente();
                cliente.setEmail(rs.getString("email"));
                cliente.setNome(rs.getString("nome"));
                cliente.setIdade(rs.getInt("idade"));
                cliente.setFaixaSalarial(rs.getDouble("faixa_salarial"));
                
                Conta conta = new Conta();
                conta.setClienteId(cliente.getEmail());
                conta.setFaixaSalarial(cliente.getFaixaSalarial());
                conta.setId(rs.getInt("id"));
                conta.setLimite(rs.getDouble("limite"));
                conta.setTipo(TipoConta.valueOf(rs.getString("tipo")));

                NovaContaCliente novaContaCliente = new NovaContaCliente();
                novaContaCliente.setCliente(cliente);
                novaContaCliente.setConta(conta);

                return novaContaCliente;
            }
        };
    }
}
