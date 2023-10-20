package com.example.demo.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "TB_PACIENTE")
public class PacienteVO  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long codPaciente;
	private Long codPessoa;
	private Double peso;
	private Double altura;
	
	private PessoaVO pessoaVO;


	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="COD_PACIENTE")
	public Long getCodPaciente() {
		return codPaciente;
	}
	public void setCodPaciente(Long codPaciente) {
		this.codPaciente = codPaciente;
	}
	
	@Column(name="COD_PESSOA")
	public Long getCodPessoa() {
		return codPessoa;
	}
	
	public void setCodPessoa(Long codPessoa) {
		this.codPessoa = codPessoa;
	}
	
	@Column(name="PESO", nullable = false, length = 4)
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	@Column(name="ALTURA", nullable = false, length = 100)
	public Double getAltura() {
		return altura;
	}
	public void setAltura(Double altura) {
		this.altura = altura;
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
