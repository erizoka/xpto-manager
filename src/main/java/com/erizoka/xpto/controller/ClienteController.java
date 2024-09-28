package com.erizoka.xpto.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erizoka.xpto.data.vo.ClienteVO;
import com.erizoka.xpto.service.ClienteService;


@RestController
@RequestMapping("api/cliente/v1")
public class ClienteController {

	private final ClienteService service;

	public ClienteController(ClienteService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteVO>> listAll(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<ClienteVO> finByEmail(@PathVariable String email){
		return ResponseEntity.ok(service.findByEmail(email));
	}
	
	@DeleteMapping("/{email}")
	public ResponseEntity<?> deleteById(@PathVariable String email){
		service.deleteById(email);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ClienteVO create(@RequestBody ClienteVO cliente){
		return service.save(cliente);
	}

	@PutMapping("update")
	public ClienteVO update(@RequestBody ClienteVO cliente) {
		return service.update(cliente);
	}
}
