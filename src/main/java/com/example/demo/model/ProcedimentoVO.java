package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "TB_PROCEDIMENTO")
public class ProcedimentoVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long codProcedimento;
	private Long codPaciente;
	private Long codMedico;
	private Date dataAtendimento;
	private Date horaAtendimento;
	private String estado;
	private String haConvenio;
	private String tipoConvenio;
	private String retorno;
	
	private MedicoVO medicoVO;
	private PacienteVO pacienteVO;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="COD_PROCEDIMENTO")
	public Long getCodProcedimento() {
		return codProcedimento;
	}
	public void setCodProcedimento(Long codProcedimento) {
		this.codProcedimento = codProcedimento;
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
	
	@Column(name="HORA_ATENDIMENTO")
	public Date getHoraAtendimento() {
		return horaAtendimento;
	}
	public void setHoraAtendimento(Date horaAtendimento) {
		this.horaAtendimento = horaAtendimento;
	}
	
	@Column(name="ESTADO")
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@Column(name="HA_CONVENIO")
	public String getHaConvenio() {
		return haConvenio;
	}
	public void setHaConvenio(String haConvenio) {
		this.haConvenio = haConvenio;
	}
	
	@Column(name="TIPO_CONVENIO")
	public String getTipoConvenio() {
		return tipoConvenio;
	}
	public void setTipoConvenio(String tipoConvenio) {
		this.tipoConvenio = tipoConvenio;
	}
	
	@Column(name="RETORNO")
	public String getRetorno() {
		return retorno;
	}
	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}
	
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="COD_MEDICO", referencedColumnName = "COD_MEDICO", insertable = false, updatable=false)
	public MedicoVO getMedicoVO() {
		return medicoVO;
	}
	public void setMedicoVO(MedicoVO medicoVO) {
		this.medicoVO = medicoVO;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="COD_PACIENTE", referencedColumnName = "COD_PACIENTE", insertable = false, updatable=false)
	public PacienteVO getPacienteVO() {
		return pacienteVO;
	}
	public void setPacienteVO(PacienteVO pacienteVO) {
		this.pacienteVO = pacienteVO;
	}
	
}
