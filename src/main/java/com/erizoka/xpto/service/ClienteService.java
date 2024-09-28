package com.erizoka.xpto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.erizoka.xpto.data.vo.ClienteVO;
import com.erizoka.xpto.entity.Cliente;
import com.erizoka.xpto.exception.NullIdException;
import com.erizoka.xpto.exception.RequiredObjectIsNullException;
import com.erizoka.xpto.exception.ResourceNotFoundException;
import com.erizoka.xpto.mapper.DozerMapper;
import com.erizoka.xpto.repository.ClienteRepository;

@Service
public class ClienteService {

	private final ClienteRepository repository;

	public ClienteService(ClienteRepository repository) {
		this.repository = repository;
	}
	
	public List<ClienteVO> findAll(){
		List<Cliente> clientes = repository.findAll();
		List<ClienteVO> voList = new ArrayList<>();
		for (Cliente cliente : clientes) {
			voList.add(DozerMapper.parseObject(cliente, ClienteVO.class));
		}
		return voList;
	}
	
	public ClienteVO findByEmail(String email) {
		Cliente cliente = repository.findById(email).orElse(null);
		ClienteVO vo = DozerMapper.parseObject(cliente, ClienteVO.class);
			
		if (vo == null) throw new NullIdException("Nenhum cliente encontrado para o email: " + email);
		
		return vo;	
	}
	
	public void deleteById(String email) {
		repository.deleteById(email);
		// update para deletar conta vinculada em cascata
	}
	
	public ClienteVO save(ClienteVO clienteVO) {
		if (clienteVO == null) throw new RequiredObjectIsNullException();
		
		var entity = DozerMapper.parseObject(clienteVO, Cliente.class);
		var vo = DozerMapper.parseObject(repository.save(entity), ClienteVO.class);
		return vo;
	}
	
	public ClienteVO update(ClienteVO clienteVO) {
		if (clienteVO == null) throw new RequiredObjectIsNullException();
		
		Cliente entity = repository.findById(clienteVO.getEmail())
			.orElseThrow(() -> new ResourceNotFoundException("Não há cliente para este email: " + clienteVO.getEmail()));
			
		entity.setNome(clienteVO.getNome());
		entity.setIdade(clienteVO.getIdade());
		entity.setFaixaSalarial(clienteVO.getFaixaSalarial());

		Cliente updatedEntity = repository.save(entity);
		ClienteVO updatedVO = DozerMapper.parseObject(updatedEntity, ClienteVO.class);
		
		return updatedVO;
		// update para atualizar conta vinculada em cascata
	}
}
