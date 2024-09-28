package com.erizoka.xpto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.erizoka.xpto.data.vo.ContaVO;
import com.erizoka.xpto.entity.Conta;
import com.erizoka.xpto.enuns.TipoConta;
import com.erizoka.xpto.exception.RequiredObjectIsNullException;
import com.erizoka.xpto.exception.ResourceNotFoundException;
import com.erizoka.xpto.mapper.DozerMapper;
import com.erizoka.xpto.repository.ContasBancariasRepository;

@Service
public class ContaService {

	private final ContasBancariasRepository repository;

	public ContaService(ContasBancariasRepository repository) {
		this.repository = repository;
	}
	
	public List<ContaVO> findAll(){
		List<Conta> contas = repository.findAll();
		List<ContaVO> voList = new ArrayList<>();
		for (Conta conta : contas) {
			voList.add(DozerMapper.parseObject(conta, ContaVO.class));
		}
		return voList;
	}
	
	public ContaVO findById(Integer id) {
		Conta idFound = repository.findById(id).orElse(null);
			
		if (idFound == null) throw new NullPointerException("Nenhuma conta encontrada para o id: " + id);
		
		ContaVO conta = DozerMapper.parseObject(idFound, ContaVO.class);

		return conta;	
	}
	
	public List<ContaVO> findByTipoConta(TipoConta tipo) {
		return DozerMapper.parseListObjects(repository.findByTipoConta(tipo), ContaVO.class);
	}
	
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
	public void update(ContaVO contaVO) {
		if (contaVO == null) throw new RequiredObjectIsNullException();
		Conta entity = repository.findById(contaVO.getId())
			.orElseThrow(() -> new ResourceNotFoundException("Não há conta para o id: " + contaVO.getId()));

		entity.setClienteId(contaVO.getClienteId());
		entity.setFaixaSalarial(contaVO.getFaixaSalarial());
		entity.setLimite(contaVO.getLimite());
		entity.setTipo(contaVO.getTipo());

		repository.save(entity);
	}
}
