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
import com.example.demo.model.EspecialidadeVO;
import com.example.demo.service.EspecialidadeService;

@RestController
@RequestMapping("/especialidade")
public class EspecialidadeRestCtr {
	@Autowired
	private EspecialidadeService especialidadeService;
	
	@GetMapping("/findAll")
	public Retorno findAll() {
		return especialidadeService.findAll();	
	}
	
	@GetMapping("/findByCodEspecialidade/{codEspecialidade}")
	public Retorno findByCodEspecialidade(@PathVariable Long codEspecialidade) {
		return especialidadeService.findByCodEspecialidade(codEspecialidade);	
	}
	
	@PostMapping("/create")
	public Retorno gravarEspecialidade(@RequestBody EspecialidadeVO EspecialidadeVO) {
		return especialidadeService.gravarEspecialidade(EspecialidadeVO);	
	}
	
	@PutMapping("/update")
	public Retorno editarEspecialidade(@RequestBody EspecialidadeVO EspecialidadeVO) {
		return especialidadeService.editarEspecialidade(EspecialidadeVO);	
	}
	
	@DeleteMapping("/delete/{codEspecialidade}")
	public Retorno deleteEspecialidade(@PathVariable Long codEspecialidade) {
		return especialidadeService.deleteEspecialidade(codEspecialidade);	
	}
}
