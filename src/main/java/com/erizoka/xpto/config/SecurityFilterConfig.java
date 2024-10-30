package com.erizoka.xpto.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.filter.OncePerRequestFilter;

import com.erizoka.xpto.entity.Cliente;
import com.erizoka.xpto.repository.ClienteRepository;
import com.erizoka.xpto.service.AuthService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class SecurityFilterConfig extends OncePerRequestFilter{
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	ClienteRepository repository;

	@SuppressWarnings("null")
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		if (request.getServletPath().equals("/auth/login")) {
		    filterChain.doFilter(request, response);
		    return;
		}

		String token = extractToken(request);
		if (token != null) {
			String username = authService.validateJwtToken(token);
			Cliente user = repository.findByUsername(username);
			var authenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		}
		
		filterChain.doFilter(request, response);
	}

	private String extractToken(HttpServletRequest request) {
		String authHeader = request.getHeader("Authorization");
		if (authHeader == null) { return null; }
		if (!authHeader.split(" ")[0].equals("Bearer")) { return null; }
		return authHeader.split(" ")[1];
	}

	
	@Bean
    UserDetailsService userDetailsService() {
        return username -> {
            Cliente user = repository.findByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("Usuário não encontrado");
            }
            return user;
        };
    }
}
