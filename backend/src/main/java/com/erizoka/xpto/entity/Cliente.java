package com.erizoka.xpto.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
	@Column(name="privilege")
	private Roles privilege;
	
	@OneToOne(mappedBy = "cliente")
	@Transient
	@JsonIgnore
	Conta conta;
	
	public Cliente() {}
	
	public Cliente(String email, String nome, Integer idade, 
		String senha, Double faixa_salarial, Roles privilege, Conta conta) {
		this.email = email;
		this.nome = nome;
		this.idade = idade;
		this.senha = senha;
		this.faixa_salarial = faixa_salarial;
		this.privilege = privilege;
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
	
	public Roles getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Roles privilege) {
		this.privilege = privilege;
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
		return getEmail();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (this.privilege == Roles.ADMIN) {
			return List.of(
				new SimpleGrantedAuthority("ROLE_ADMIN"),
				new SimpleGrantedAuthority("ROLE_USER"),
				new SimpleGrantedAuthority("ROLE_CLIENT")
			);
		} else if (this.privilege == Roles.USER) {
			return List.of(
					new SimpleGrantedAuthority("ROLE_USER"),
					new SimpleGrantedAuthority("ROLE_CLIENT")
			);
		}
		return List.of(new SimpleGrantedAuthority("ROLE_CLIENT"));
	}
}
