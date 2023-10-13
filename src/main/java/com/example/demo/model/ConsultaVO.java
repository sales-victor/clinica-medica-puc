package com.example.demo.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CONSULTA")
public class ConsultaVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long codConsulta;
	private Long codProcedimento;
	private Long codEspecialidade;
	
	private EspecialidadeVO especialidadeVO;
	private ProcedimentoVO procedimentoVO;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="COD_CONSUTA")
	public Long getCodConsulta() {
		return codConsulta;
	}
	public void setCodConsulta(Long codConsulta) {
		this.codConsulta = codConsulta;
	}
	
	@Column(name="COD_PROCEDIMENTO")
	public Long getCodProcedimento() {
		return codProcedimento;
	}
	public void setCodProcedimento(Long codProcedimento) {
		this.codProcedimento = codProcedimento;
	}
	
	@Column(name="COD_ESPECIALIDADE")
	public Long getCodEspecialidade() {
		return codEspecialidade;
	}
	public void setCodEspecialidade(Long codEspecialidade) {
		this.codEspecialidade = codEspecialidade;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="COD_ESPECIALIDADE", referencedColumnName = "COD_ESPECIALIDADE", insertable = false, updatable=false)
	public EspecialidadeVO getEspecialidadeVO() {
		return especialidadeVO;
	}
	public void setEspecialidadeVO(EspecialidadeVO especialidadeVO) {
		this.especialidadeVO = especialidadeVO;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="COD_PROCEDIMENTO", referencedColumnName = "COD_PROCEDIMENTO", insertable = false, updatable=false)
	public ProcedimentoVO getProcedimentoVO() {
		return procedimentoVO;
	}
	public void setProcedimentoVO(ProcedimentoVO procedimentoVO) {
		this.procedimentoVO = procedimentoVO;
	}
	
	

}
