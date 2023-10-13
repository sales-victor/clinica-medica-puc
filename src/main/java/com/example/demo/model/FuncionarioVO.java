package com.example.demo.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "TB_FUNCIONARIO")
public class FuncionarioVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long codFuncionario;
	private Long codPessoa;
	private Long codCargo;
	private String turno;
	
	private CargoVO cargoVO;
	private MedicoVO medicoVO;
	private PessoaVO pessoaVO;
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="COD_FUNCIONARIO")
	public Long getCodFuncionario() {
		return codFuncionario;
	}
	public void setCodFuncionario(Long codFuncionario) {
		this.codFuncionario = codFuncionario;
	}
	
	@Column(name="COD_PESSOA")
	public Long getCodPessoa() {
		return codPessoa;
	}
	public void setCodPessoa(Long codPessoa) {
		this.codPessoa = codPessoa;
	}
	
	@Column(name="COD_CARGO")
	public Long getCodCargo() {
		return codCargo;
	}
	public void setCodCargo(Long codCargo) {
	this.codCargo = codCargo;
	}
	
	@Column(name="TURNO")
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="COD_CARGO", referencedColumnName = "COD_CARGO", insertable = false, updatable=false)
	public CargoVO getCargoVO() {
		return cargoVO;
	}
	public void setCargoVO(CargoVO cargoVO) {
		this.cargoVO = cargoVO;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="COD_FUNCIONARIO", referencedColumnName = "COD_FUNCIONARIO", insertable = false, updatable=false)
	public MedicoVO getMedicoVO() {
		return medicoVO;
	}
	public void setMedicoVO(MedicoVO medicoVO) {
		this.medicoVO = medicoVO;
	}
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="COD_PESSOA", referencedColumnName = "COD_PESSOA", insertable = false, updatable=false)
	public PessoaVO getPessoaVO() {
		return pessoaVO;
	}
	public void setPessoaVO(PessoaVO pessoaVO) {
		this.pessoaVO = pessoaVO;
	}
	
	
}
