package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioRestCtr {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
//	@PostMapping("/create")
//	public FuncionarioVO create(@RequestBody FuncionarioDTO funcionarioDTO) {
//		return funcionarioService.create(funcionarioDTO);
//	}
	
}
