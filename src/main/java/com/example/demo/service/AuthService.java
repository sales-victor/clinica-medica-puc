package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.security.AccountCredentialsVO;
import com.example.demo.model.security.TokenVO;
import com.example.demo.persistence.UserRepository;
import com.example.demo.security.jwt.JwtTokenProvider;

@Service
public class AuthService {
	
	@Autowired
	private JwtTokenProvider tokenProvider;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepository;
	
	@SuppressWarnings("rawtypes")
	public ResponseEntity signin(AccountCredentialsVO data) {
		try {
			var username = data.getUsername();
			var password = data.getPassword();
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
			var user = userRepository.findByUserName(username);
			var tokenResponde = new TokenVO();
			if(user != null ) {
				tokenResponde = tokenProvider.createAccessToken(username, user.getRoles());
			} else {
				throw new UsernameNotFoundException("Usuario não encontrado");
			}
			return ResponseEntity.ok(tokenResponde);
		} catch (Exception e) {
			throw new BadCredentialsException("Login e senha invalidos");
		}
		
	}


}
