package com.erizoka.xpto.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.erizoka.xpto.entity.Cliente;
import com.erizoka.xpto.exception.ResourceNotFoundException;
import com.erizoka.xpto.repository.ClienteRepository;
import com.erizoka.xpto.request.AuthRequest;

@Service
public class AuthService {

	@Autowired
	ClienteRepository repository;
	
	public String getToken(AuthRequest auth) {
		try {
			
			Cliente user = repository.findByUsername(auth.getUsername());
			return generateToken(user);
			
		} catch (ResourceNotFoundException error) {
			throw new BadCredentialsException("User não encontrado");
		} 
	}

	public String generateToken(Cliente user) {
		try {
			
			Algorithm algorithm = Algorithm.HMAC256("my-secret");
			
			return JWT.create()
					.withIssuer("XPTO Manager")
					.withSubject(user.getUsername())
					.withExpiresAt(getExpirationDate())
					.sign(algorithm);
			
		} catch (JWTCreationException e) {
			throw new RuntimeException("Falha ao gerar token: " + e.getMessage());
		}
	}
	
	public String validateJwtToken(String token){
		try {
			
			Algorithm algorithm = Algorithm.HMAC256("my-secret");
			
			return JWT.require(algorithm)
					.withIssuer("XPTO Manager")
					.build()
					.verify(token)
					.getSubject();
			
		} catch (JWTVerificationException e) {
			throw new RuntimeException("Falha ao autenticar: " + e.getMessage());
		}
	}

	private Instant getExpirationDate() {
		return LocalDateTime.now()
				.plusHours(2)
				.toInstant(ZoneOffset.of("-03:00"));
	}
}
