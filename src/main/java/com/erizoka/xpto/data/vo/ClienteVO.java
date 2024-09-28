package com.erizoka.xpto.data.vo;

public class ClienteVO {

	private String email;
	
	private String nome;
	
	private Integer idade;
	
	private Double faixa_salarial;
	
	public ClienteVO(String nome, String email, Integer idade, Double faixa_salarial) {
		this.nome = nome;
		this.email = email;
		this.idade = idade;
		this.faixa_salarial = faixa_salarial;
	}
	
	public ClienteVO() {}
	
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
