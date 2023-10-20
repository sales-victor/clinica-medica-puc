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
import jakarta.persistence.Transient;

@Entity
@Table(name = "TB_MEDICO")
public class MedicoVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long codMedico;
	private Long codFuncionario;
	private Long codEspecialidade;
	private String codCrm;
	
	private EspecialidadeVO especialidadeVO;
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="COD_MEDICO")
	public Long getCodMedico() {
		return codMedico;
	}
	public void setCodMedico(Long codMedico) {
		this.codMedico = codMedico;
	}
	
	@Column(name="COD_FUNCIONARIO")
	public Long getCodFuncionario() {
		return codFuncionario;
	}
	public void setCodFuncionario(Long codFuncionario) {
		this.codFuncionario = codFuncionario;
	}
	
	@Column(name="COD_ESPECIALIDADE")
	public Long getCodEspecialidade() {
		return codEspecialidade;
	}
	public void setCodEspecialidade(Long codEspecialidade) {
		this.codEspecialidade = codEspecialidade;
	}
	@Column(name="COD_CRM")
	public String getCodCrm() {
		return codCrm;
	}
	public void setCodCrm(String codCrm) {
		this.codCrm = codCrm;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="COD_ESPECIALIDADE", referencedColumnName = "COD_ESPECIALIDADE", insertable = false, updatable=false)
	public EspecialidadeVO getEspecialidadeVO() {
		return especialidadeVO;
	}
	public void setEspecialidadeVO(EspecialidadeVO especialidadeVO) {
		this.especialidadeVO = especialidadeVO;
	}
}
