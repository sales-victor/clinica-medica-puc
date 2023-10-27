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

import com.example.demo.dto.Retorno;
import com.example.demo.model.MedicamentoVO;
import com.example.demo.service.MedicamentoService;

@RestController
@RequestMapping("/medicamento")
public class MedicamentoRestCtr {

	@Autowired
	private MedicamentoService medicamentoService;
	
	@GetMapping("/findAll")
	public Retorno findAll() {
		return medicamentoService.findAll();	
	}
	
	@GetMapping("/findByCodMedicamento/{codMedicamento}")
	public Retorno findByCodMedicamento(@PathVariable Long codMedicamento) {
		return medicamentoService.findByCodMedicamento(codMedicamento);	
	}
	
	@PostMapping("/create")
	public Retorno gravarMedicamento(@RequestBody MedicamentoVO MedicamentoVO) {
		return medicamentoService.gravarMedicamento(MedicamentoVO);	
	}
	
	@PutMapping("/update")
	public Retorno editarMedicamento(@RequestBody MedicamentoVO MedicamentoVO) {
		return medicamentoService.editarMedicamento(MedicamentoVO);	
	}
	
	@DeleteMapping("/delete/{codMedicamento}")
	public Retorno deleteMedicamento(@PathVariable Long codConsulta) {
		return medicamentoService.deleteMedicamento(codConsulta);	
	}
}
