package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PacienteVO;
import com.example.demo.persistence.PacienteRepository;
import com.example.demo.service.PacienteService;

@RestController
@RequestMapping("/paciente")
public class PacienteRestCtr {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	@Autowired
	private PacienteService pacienteService; 
	

	@GetMapping("/findAll")
	public Iterable<PacienteVO> findAll() {
		return pacienteRepository.findAll();	
	}
	
//	@PostMapping("/create")
//	public PacienteVO create(@RequestBody PacienteDTO pacienteDTO) {
//		return pacienteService.create(pacienteDTO);
//	}
	
	@GetMapping("/findByCodPessoa/{codPessoa}")
	public PacienteVO findByCodPessoa(@PathVariable Long codPessoa) {
		return pacienteRepository.findByCodPessoa(codPessoa);	
	}
	
}
