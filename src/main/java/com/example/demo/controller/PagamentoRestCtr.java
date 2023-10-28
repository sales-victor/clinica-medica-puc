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
import com.example.demo.model.PagamentoVO;
import com.example.demo.service.PagamentoService;

@RestController
@RequestMapping("/pagamento")
public class PagamentoRestCtr {
	
	@Autowired
	private PagamentoService pagamentoService;
	
	@GetMapping("/findAll")
	public Retorno findAll() {
		return pagamentoService.findAll();	
	}
	
	@GetMapping("/findByCodPagamento/{codPagamento}")
	public Retorno findByCodPagamento(@PathVariable Long codPagamento) {
		return pagamentoService.findByCodPagamento(codPagamento);	
	}
	
	@PostMapping("/create")
	public Retorno gravarPagamento(@RequestBody PagamentoVO pagamentoVO) {
		return pagamentoService.gravarPagamento(pagamentoVO);	
	}
	
	@PutMapping("/update")
	public Retorno editarPagamento(@RequestBody PagamentoVO pagamentoVO) {
		return pagamentoService.editarPagamento(pagamentoVO);	
	}
	
	@DeleteMapping("/delete/{codPagamento}")
	public Retorno deletePagamento(@PathVariable Long codPagamento) {
		return pagamentoService.deletePagamento(codPagamento);	
	}
}
