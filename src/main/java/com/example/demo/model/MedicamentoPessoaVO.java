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
@Table(name = "TB_MEDICAMENTO_PESSOA")
public class MedicamentoPessoaVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long codMedicamentoPessoa;
	private Long codPaciente;
	private Long codMedicamento;
	private MedicamentoVO medicamentoVO;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="COD_MEDICAMENTO_PESSOA")
	public Long getCodMedicamentoPessoa() {
		return codMedicamentoPessoa;
	}
	public void setCodMedicamentoPessoa(Long codMedicamentoPessoa) {
		this.codMedicamentoPessoa = codMedicamentoPessoa;
	}
	@Column(name="COD_PACIENTE")
	public Long getCodPaciente() {
		return codPaciente;
	}
	public void setCodPaciente(Long codPaciente) {
		this.codPaciente = codPaciente;
	}

	@Column(name="COD_MEDICAMENTO")
	public Long getCodMedicamento() {
		return codMedicamento;
	}
	
	public void setCodMedicamento(Long codMedicamento) {
		this.codMedicamento = codMedicamento;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="COD_MEDICAMENTO", referencedColumnName = "COD_MEDICAMENTO", insertable = false, updatable=false)
	public MedicamentoVO getMedicamentoVO() {
		return medicamentoVO;
	}
	public void setMedicamentoVO(MedicamentoVO medicamentoVO) {
		this.medicamentoVO = medicamentoVO;
	}
	
}
