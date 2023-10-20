package com.example.demo.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_MEDICAMENTO")
public class MedicamentoVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nomeMedicamento;
	private Long codMedicamento;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="COD_MEDICAMENTO")
	public Long getCodMedicamento() {
		return codMedicamento;
	}
	public void setCodMedicamento(Long codMedicamento) {
		this.codMedicamento = codMedicamento;
	}
	
	@Column(name="NOME_MEDICAMENTO")
	public String getNomeMedicamento() {
		return nomeMedicamento;
	}
	public void setNomeMedicamento(String nomeMedicamento) {
		this.nomeMedicamento = nomeMedicamento;
	}

}
