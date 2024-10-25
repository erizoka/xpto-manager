package com.erizoka.xpto.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.erizoka.xpto.enuns.Roles;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "cliente")
public class Cliente implements UserDetails {
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private String email;
	
	@Column
	private String nome;
	
	@Column
	private Integer idade;
	
	@Column
	private String senha;
	
	@Column
	private Double faixa_salarial;
	
	@Enumerated(EnumType.STRING)
	@Column
	private Roles role;
	
	@OneToOne(mappedBy = "cliente")
	@Transient
	@JsonIgnore
	Conta conta;
	
	public Cliente() {}
	
	public Cliente(String email, String nome, Integer idade, String senha, Double faixa_salarial, Roles role,
			Conta conta) {
		this.email = email;
		this.nome = nome;
		this.idade = idade;
		this.senha = senha;
		this.faixa_salarial = faixa_salarial;
		this.role = role;
		this.conta = conta;
	}

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

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	@Override
	public String getPassword() {
		return getSenha();
	}

	@Override
	public String getUsername() {
		return email;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
}
