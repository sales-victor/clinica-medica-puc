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
import com.example.demo.model.CargoVO;
import com.example.demo.service.CargoService;

@RestController
@RequestMapping("/cargo")
public class CargoRestCtr {
	
	@Autowired
	private CargoService cargoService;
	
	@GetMapping("/findAll")
	public Retorno findAll() {
		return cargoService.findAll();	
	}
	
	@GetMapping("/findByCodCargo/{codCargo}")
	public Retorno findByCodCargo(@PathVariable Long codCargo) {
		return cargoService.findByCodCargo(codCargo);	
	}
	
	@PostMapping("/create")
	public Retorno gravarCargo(@RequestBody CargoVO cargoVO) {
		return cargoService.gravarCargo(cargoVO);	
	}
	
	@PutMapping("/update")
	public Retorno editarCargo(@RequestBody CargoVO cargoVO) {
		return cargoService.editarCargo(cargoVO);	
	}
	
	@DeleteMapping("/delete/{codCargo}")
	public Retorno deleteCargo(@PathVariable Long codCargo) {
		return cargoService.deleteCargo(codCargo);	
	}

}
