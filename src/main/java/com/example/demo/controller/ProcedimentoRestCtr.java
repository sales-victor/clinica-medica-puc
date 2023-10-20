package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ParamsConsultaDTO;
import com.example.demo.dto.ParamsExameDTO;
import com.example.demo.dto.Retorno;
import com.example.demo.service.ProcedimentoService;

@RestController
@RequestMapping("/procedimento")
public class ProcedimentoRestCtr {
	
	@Autowired
	private ProcedimentoService procedimentoService;
	
	@PostMapping("/consulta/create")
	public Retorno gravarConsulta(@RequestBody ParamsConsultaDTO paramsConsultaDTO) {
		return procedimentoService.gravarConsulta(paramsConsultaDTO);	
	}
	
	@GetMapping("/consulta/findByCodConsulta/{codConsulta}")
	public Retorno findByCodConsulta(@PathVariable Long codConsulta) {
		return procedimentoService.findByCodConsulta(codConsulta);	
	}
	
	@PostMapping("/exame/create")
	public Retorno gravarExame(@RequestBody ParamsExameDTO paramsExameDTO) {
		return procedimentoService.gravarExame(paramsExameDTO);	
	}
	
	@GetMapping("/exame/findByCodExame/{codExame}")
	public Retorno findByCodExame(@PathVariable Long codExame) {
		return procedimentoService.findByCodExame(codExame);	
	}

}
