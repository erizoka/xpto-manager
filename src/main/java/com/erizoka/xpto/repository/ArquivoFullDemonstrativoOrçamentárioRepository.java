package com.erizoka.xpto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erizoka.xpto.entity.ArquivoFullDemonstrativoOrçamentário;

@Repository
public interface ArquivoFullDemonstrativoOrçamentárioRepository 
			extends JpaRepository<ArquivoFullDemonstrativoOrçamentário, Long>{}
