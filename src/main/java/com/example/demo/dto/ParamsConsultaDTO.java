package com.example.demo.dto;

import com.example.demo.model.ConsultaVO;
import com.example.demo.model.PessoaVO;
import com.example.demo.model.ProcedimentoVO;

public class ParamsConsultaDTO {
	
	private ProcedimentoVO procedimentoVO;
	private ConsultaVO consultaVO;
	private PessoaVO dadosPaciente;
	private PessoaVO dadosMedico;
	
	public ProcedimentoVO getProcedimentoVO() {
		return procedimentoVO;
	}
	public void setProcedimentoVO(ProcedimentoVO procedimentoVO) {
		this.procedimentoVO = procedimentoVO;
	}
	
	public ConsultaVO getConsultaVO() {
		return consultaVO;
	}
	public void setConsultaVO(ConsultaVO consultaVO) {
		this.consultaVO = consultaVO;
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
