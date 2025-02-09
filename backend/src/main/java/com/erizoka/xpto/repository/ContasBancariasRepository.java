package com.erizoka.xpto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.erizoka.xpto.entity.Cliente;
import com.erizoka.xpto.entity.Conta;
import com.erizoka.xpto.enuns.TipoConta;

@Repository
public interface ContasBancariasRepository extends JpaRepository<Conta, Integer>{

	@Query("SELECT c FROM Conta c WHERE c.tipo = :tipo")
	public List<Conta> findByTipoConta(@Param("tipo") TipoConta tipo);
	
	@Query("SELECT c FROM Conta c WHERE c.cliente.email = :clienteId")
	public Conta findByClienteId(@Param("clienteId") String clienteId);
	
	@Modifying
	@Query("DELETE FROM Conta c WHERE c.cliente = :cliente")
	public void deleteByCliente(@Param("cliente") Cliente cliente);
}