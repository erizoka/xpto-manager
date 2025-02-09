package com.erizoka.xpto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.erizoka.xpto.request.AuthRequest;
import com.erizoka.xpto.response.AuthResponse;
import com.erizoka.xpto.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/login")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<AuthResponse> login(@RequestBody final AuthRequest auth) {
		try {
	        UsernamePasswordAuthenticationToken userAuthenticationToken = 
	                new UsernamePasswordAuthenticationToken(auth.getUsername(), auth.getPassword());
	        
	        authenticationManager.authenticate(userAuthenticationToken);
	        
	        AuthResponse token = new AuthResponse(authService.getToken(auth));
	        return ResponseEntity.ok(token);
	        
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new AuthResponse(e.getMessage()));
	    }
	}
}
