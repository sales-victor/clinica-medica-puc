package com.example.demo.dto;

import com.example.demo.model.ExameVO;
import com.example.demo.model.PessoaVO;
import com.example.demo.model.ProcedimentoVO;

public class ParamsExameDTO {
	
	private ProcedimentoVO procedimentoVO;
	private ExameVO exameVO;
	private PessoaVO dadosPaciente;
	private PessoaVO dadosMedico;
	
	public ProcedimentoVO getProcedimentoVO() {
		return procedimentoVO;
	}
	public void setProcedimentoVO(ProcedimentoVO procedimentoVO) {
		this.procedimentoVO = procedimentoVO;
	}
	public ExameVO getExameVO() {
		return exameVO;
	}
	public void setExameVO(ExameVO exameVO) {
		this.exameVO = exameVO;
	}
	public PessoaVO getDadosPaciente() {
		return dadosPaciente;
	}
	public void setDadosPaciente(PessoaVO dadosPaciente) {
		this.dadosPaciente = dadosPaciente;
	}
	public PessoaVO getDadosMedico() {
		return dadosMedico;
	}
	public void setDadosMedico(PessoaVO dadosMedico) {
		this.dadosMedico = dadosMedico;
	}
	
	
}
