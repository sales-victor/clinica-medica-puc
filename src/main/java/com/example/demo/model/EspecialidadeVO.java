package com.example.demo.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ESPECIALIDADE")
public class EspecialidadeVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long codEspecialidade;
	private String descricaoEspecialidade;
	private Double valorEspecialidade;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="COD_ESPECIALIDADE")
	public Long getCodEspecialidade() {
		return codEspecialidade;
	}
	public void setCodEspecialidade(Long codEspecialidade) {
		this.codEspecialidade = codEspecialidade;
	}
	@Column(name="DESCRICAO_ESPECIALIDADE")
	public String getDescricaoEspecialidade() {
		return descricaoEspecialidade;
	}
	public void setDescricaoEspecialidade(String descricaoEspecialidade) {
		this.descricaoEspecialidade = descricaoEspecialidade;
	}
	
	@Column(name="VALOR_ESPECIALIDADE")
	public Double getValorEspecialidade() {
		return valorEspecialidade;
	}
	public void setValorEspecialidade(Double valorEspecialidade) {
		this.valorEspecialidade = valorEspecialidade;
	}


	
	
}
