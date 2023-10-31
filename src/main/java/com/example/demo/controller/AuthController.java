package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.security.AccountCredentialsVO;
import com.example.demo.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	AuthService authService;

	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/login")
	public ResponseEntity signin(@RequestBody AccountCredentialsVO data) {
		if (dataIsNotNull(data)) 
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("credenciais invalidas");
		var token = authService.signin(data);
		if(token == null) return ResponseEntity.status(HttpStatus.FORBIDDEN).body("credenciais invalidas");
		return token;
		
		
	}

	private boolean dataIsNotNull(AccountCredentialsVO data) {
		return data == null || data.getUsername() == null|| data.getUsername().isBlank() || data.getPassword() == null || data.getPassword().isBlank();
	}
}
