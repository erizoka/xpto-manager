package com.erizoka.xpto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.erizoka.xpto.entity.Conta;
import com.erizoka.xpto.enuns.TipoConta;
import com.erizoka.xpto.repository.ContasBancariasRepository;

@Service
public class ContaService {

	private ContasBancariasRepository repository;

	public ContaService(ContasBancariasRepository repository) {
		this.repository = repository;
	}
	
	public List<Conta> findAll(){
		return repository.findAll();
	}
	
	public Conta findById(Integer id) {
		Conta idFound = repository.findById(id).orElse(null);
			
		if (idFound == null) throw new NullPointerException("Nenhuma conta encontrada para o id: " + id);
		
		return idFound;	
	}
	
	
	public List<Conta> findByTipoConta(TipoConta tipo) {
		return repository.findByTipoConta(tipo);
	}
	
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
}
