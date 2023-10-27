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
import com.example.demo.model.TipoExameVO;
import com.example.demo.service.TipoDeExameService;

@RestController
@RequestMapping("/tipo-de-exame")
public class TipoDeExameRestCtr {
	@Autowired
	private TipoDeExameService tipoDeExameService;
	
	@GetMapping("/findAll")
	public Retorno findAll() {
		return tipoDeExameService.findAll();	
	}
	
	@GetMapping("/findByCodTipoExame/{codTipoExame}")
	public Retorno findByCodTipoExame(@PathVariable Long codTipoExame) {
		return tipoDeExameService.findByCodTipoExame(codTipoExame);	
	}
	
	@PostMapping("/create")
	public Retorno gravarTipoExame(@RequestBody TipoExameVO TipoExameVO) {
		return tipoDeExameService.gravarTipoExame(TipoExameVO);	
	}
	
	@PutMapping("/update")
	public Retorno editarTipoExame(@RequestBody TipoExameVO TipoExameVO) {
		return tipoDeExameService.editarTipoExame(TipoExameVO);	
	}
	
	@DeleteMapping("/delete/{codTipoExame}")
	public Retorno deleteTipoExame(@PathVariable Long codTipoExame) {
		return tipoDeExameService.deleteTipoExame(codTipoExame);	
	}

}
