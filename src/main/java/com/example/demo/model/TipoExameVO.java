package com.example.demo.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_TIPO_EXAME")
public class TipoExameVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long codTipoExame;
	private String descricaoExame;
	private Double valorExame;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="COD_TIPO_EXAME")
	public Long getCodTipoExame() {
		return codTipoExame;
	}
	public void setCodTipoExame(Long codTipoExame) {
		this.codTipoExame = codTipoExame;
	}
	
    @Column(name="DESCRICAO_EXAME")
	public String getDescricaoExame() {
		return descricaoExame;
	}
	public void setDescricaoExame(String descricaoExame) {
		this.descricaoExame = descricaoExame;
	}
	
    @Column(name="VALOR_EXAME")
	public Double getValorExame() {
		return valorExame;
	}
	public void setValorExame(Double valorExame) {
		this.valorExame = valorExame;
	}
	
	
}
