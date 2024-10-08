package com.erizoka.xpto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erizoka.xpto.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String>{}
