package com.erizoka.xpto.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erizoka.xpto.data.vo.ContaVO;
import com.erizoka.xpto.enuns.TipoConta;
import com.erizoka.xpto.exception.NoValidAccountTypeException;
import com.erizoka.xpto.service.ContaService;


@RestController
@RequestMapping("/api/conta/v1")
public class ContaController {

	private final ContaService service;

	public ContaController(ContaService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<ContaVO>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ContaVO> findById(@PathVariable Integer id){
		return ResponseEntity.ok(service.findById(id));
	}
	
	@GetMapping("/tipo/{tipo}")
	public ResponseEntity<List<ContaVO>> findByTipoConta(@PathVariable String tipo) throws NoValidAccountTypeException{
		try {
			
			TipoConta tipoConta = TipoConta.valueOf(tipo.toUpperCase());
			return ResponseEntity.ok(service.findByTipoConta(tipoConta));
			
		} catch (IllegalArgumentException e) {
			throw new NoValidAccountTypeException("Tipo de conta inválido!");
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/update")
	public ResponseEntity<ContaVO> update(@RequestBody ContaVO conta) {
		service.update(conta);
		return ResponseEntity.ok().build();
	}
	
}
