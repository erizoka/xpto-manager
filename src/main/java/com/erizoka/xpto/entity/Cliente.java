package com.erizoka.xpto.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@Column
	private String email;
	
	@Column
	private String nome;
	
	@Column
	private Integer idade;
	
	@Column
	private Double faixa_salarial;
	
	public Cliente(String nome, String email, Integer idade, Double faixa_salarial) {
		this.nome = nome;
		this.email = email;
		this.idade = idade;
		this.faixa_salarial = faixa_salarial;
	}
	
	public Cliente() {}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public Double getFaixaSalarial() {
		return faixa_salarial;
	}
	public void setFaixaSalarial(Double faixa_salarial) {
		this.faixa_salarial = faixa_salarial;
	}
}
