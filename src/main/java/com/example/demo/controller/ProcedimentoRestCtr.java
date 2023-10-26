package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	@GetMapping("/consulta/findAll")
	public Retorno findAllConsulta() {
		return procedimentoService.findAllConsulta();	
	}
	
	@GetMapping("/consulta/findByCodConsulta/{codConsulta}")
	public Retorno findByCodConsulta(@PathVariable Long codConsulta) {
		return procedimentoService.findByCodConsulta(codConsulta);	
	}
	
	@PostMapping("/consulta/create")
	public Retorno gravarConsulta(@RequestBody ParamsConsultaDTO paramsConsultaDTO) {
		return procedimentoService.gravarConsulta(paramsConsultaDTO);	
	}
	
	@PostMapping("/consulta/update")
	public Retorno editarConsulta(@RequestBody ParamsConsultaDTO paramsConsultaDTO) {
		return procedimentoService.editarConsulta(paramsConsultaDTO);	
	}
	
	@DeleteMapping("/consulta/delete/{codConsulta}")
	public Retorno deleteConsulta(@PathVariable Long codConsulta) {
		return procedimentoService.deleteConsulta(codConsulta);	
	}
	
	@GetMapping("/exame/findAll")
	public Retorno findAllExame() {
		return procedimentoService.findAllExame();	
	}
	
	@GetMapping("/exame/findByCodExame/{codExame}")
	public Retorno findByCodExame(@PathVariable Long codExame) {
		return procedimentoService.findByCodExame(codExame);	
	}
	
	@PostMapping("/exame/create")
	public Retorno gravarExame(@RequestBody ParamsExameDTO paramsExameDTO) {
		return procedimentoService.gravarExame(paramsExameDTO);	
	}
	
	@DeleteMapping("/exame/delete/{codExame}")
	public Retorno deleteExame(@PathVariable Long codExame) {
		return procedimentoService.deleteExame(codExame);	
	}

}
