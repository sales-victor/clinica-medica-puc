package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ParamsPessoaDTO;
import com.example.demo.dto.Retorno;
import com.example.demo.model.PessoaVO;
import com.example.demo.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaRestCtr {
	
	@Autowired
	private PessoaService pessoaService; 
	
	@GetMapping("/findAll")
	public Retorno findAll() {
		return pessoaService.findAll();	
	}
	
	@GetMapping("/findByCodPessoa/{codPessoa}")
	public Retorno findByCodPessoa(@PathVariable Long codPessoa) {
		return pessoaService.findByCodPessoa(codPessoa);	
	}
	
	
	@PostMapping("/create")
	public Retorno create(@RequestBody ParamsPessoaDTO paramsPessoaDTO) {
		return pessoaService.create(paramsPessoaDTO);	
	}
	
	@PutMapping("/update")
	public Retorno update(@RequestBody ParamsPessoaDTO paramsPessoaDTO) {
		return pessoaService.update(paramsPessoaDTO);	
	}

}
