package com.example.demo.dto;

import com.example.demo.model.PessoaVO;
import com.example.demo.model.PrescricaoVO;

public class ParamsPrescricaoDTO {
	private PrescricaoVO prescricaoVO;
	private PessoaVO dadosPaciente;
	private PessoaVO dadosMedico;
	
	public PrescricaoVO getPrescricaoVO() {
		return prescricaoVO;
	}
	public void setPrescricaoVO(PrescricaoVO prescricaoVO) {
		this.prescricaoVO = prescricaoVO;
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
