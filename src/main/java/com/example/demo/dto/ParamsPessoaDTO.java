package com.example.demo.dto;

import com.example.demo.model.FuncionarioVO;
import com.example.demo.model.PacienteVO;
import com.example.demo.model.PessoaVO;

public class ParamsPessoaDTO {
	
	private PessoaVO pessoaVO; 
	private FuncionarioVO funcionarioVO;
	private PacienteVO pacienteVO;
	
	
	public PessoaVO getPessoaVO() {
		return pessoaVO;
	}
	public void setPessoaVO(PessoaVO pessoaVO) {
		this.pessoaVO = pessoaVO;
	}
	
	public FuncionarioVO getFuncionarioVO() {
		return funcionarioVO;
	}
	public void setFuncionarioVO(FuncionarioVO funcionarioVO) {
		this.funcionarioVO = funcionarioVO;
	}
	public PacienteVO getPacienteVO() {
		return pacienteVO;
	}
	public void setPacienteVO(PacienteVO pacienteVO) {
		this.pacienteVO = pacienteVO;
	} 

}
