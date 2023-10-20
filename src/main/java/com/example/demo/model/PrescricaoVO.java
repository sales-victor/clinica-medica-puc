package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PRESCRICAO")
public class PrescricaoVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long codPrescricao;
	private Long codPaciente;
	private Long codMedico;
	private Date dataAtendimento;
	private Date dataVencimento;
	
	private List<MedicamentoPessoaVO> medicamentoPessoaVO = new ArrayList<>();
	private PacienteVO pacienteVO;
	private MedicoVO medicoVO;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="COD_PRECISAO")
	public Long getCodPrescricao() {
		return codPrescricao;
	}
	public void setCodPrescricao(Long codPrescricao) {
		this.codPrescricao = codPrescricao;
	}
	
	@Column(name="COD_PACIENTE")
	public Long getCodPaciente() {
		return codPaciente;
	}
	public void setCodPaciente(Long codPaciente) {
		this.codPaciente = codPaciente;
	}
	
	@Column(name="COD_MEDICO")
	public Long getCodMedico() {
		return codMedico;
	}
	public void setCodMedico(Long codMedico) {
		this.codMedico = codMedico;
	}
	
	@Column(name="DATA_ATENDIMENTO")
	public Date getDataAtendimento() {
		return dataAtendimento;
	}
	public void setDataAtendimento(Date dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}
	
	@Column(name="DATA_VENCIMENTO")
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = MedicamentoPessoaVO.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "COD_PACIENTE", referencedColumnName = "COD_PACIENTE", insertable = false, updatable = false)
	public List<MedicamentoPessoaVO> getMedicamentoPessoaVO() {
		return medicamentoPessoaVO;
	}
	public void setMedicamentoPessoaVO(List<MedicamentoPessoaVO> medicamentoPessoaVO) {
		this.medicamentoPessoaVO = medicamentoPessoaVO;
	}


	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="COD_PACIENTE", referencedColumnName = "COD_PACIENTE", insertable = false, updatable=false)
	public PacienteVO getPacienteVO() {
		return pacienteVO;
	}
	public void setPacienteVO(PacienteVO pacienteVO) {
		this.pacienteVO = pacienteVO;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="COD_MEDICO", referencedColumnName = "COD_MEDICO", insertable = false, updatable=false)
	public MedicoVO getMedicoVO() {
		return medicoVO;
	}
	public void setMedicoVO(MedicoVO medicoVO) {
		this.medicoVO = medicoVO;
	}
	
	

}
