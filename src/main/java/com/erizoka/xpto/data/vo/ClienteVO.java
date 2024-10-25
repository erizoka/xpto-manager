package com.erizoka.xpto.data.vo;

import com.erizoka.xpto.enuns.Roles;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ClienteVO {

	private String email;
	
	private String nome;
	
	private Integer idade;
	
	private String senha;
	
	private Double faixa_salarial;
	
	private Roles role;
	
	@JsonIgnore
	private ContaVO conta;
	
	public ClienteVO() {}

	public ClienteVO(String email, String nome, Integer idade, String senha, Double faixa_salarial, Roles role,
			ContaVO conta) {
		this.email = email;
		this.nome = nome;
		this.idade = idade;
		this.senha = senha;
		this.faixa_salarial = faixa_salarial;
		this.role = role;
		this.conta = conta;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Double getFaixaSalarial() {
		return faixa_salarial;
	}

	public void setFaixaSalarial(Double faixa_salarial) {
		this.faixa_salarial = faixa_salarial;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public ContaVO getConta() {
		return conta;
	}

	public void setConta(ContaVO conta) {
		this.conta = conta;
	}
}
