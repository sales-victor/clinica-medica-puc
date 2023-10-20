package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ParamsPrescricaoDTO;
import com.example.demo.dto.Retorno;
import com.example.demo.service.PrescricaoService;

@RestController
@RequestMapping("/prescrisao")
public class PrescrisaoRestCtr {
	
	@Autowired
	private PrescricaoService prescricaoService;
	
	@PostMapping("/create")
	public Retorno gravarPrescrisao(@RequestBody ParamsPrescricaoDTO paramsPrescricaoDTO) {
		return prescricaoService.gravarPrescrisao(paramsPrescricaoDTO);	
	}
	
	@PutMapping("/update")
	public Retorno editarPrescrisao(@RequestBody ParamsPrescricaoDTO paramsPrescricaoDTO) throws Exception {
		return prescricaoService.editarPrescrisao(paramsPrescricaoDTO);	
	}
	
	
	@GetMapping("/findByCodPrescricao/{codPrescrisao}")
	public Retorno findByCodPrescricao(@PathVariable Long codPrescrisao) {
		return prescricaoService.findByCodPrescrisao(codPrescrisao);	
	}
	
	@DeleteMapping("/delete/{codPrescrisao}")
	public Retorno deletePrescricao(@PathVariable Long codPrescrisao) {
		return prescricaoService.deletePrescrisao(codPrescrisao);	
	}
}
