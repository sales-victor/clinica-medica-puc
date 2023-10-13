package com.example.demo.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CARGO")
public class CargoVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long codCargo;
	private String cargoDescricao;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="COD_CARGO")
	public Long getCodCargo() {
		return codCargo;
	}
	public void setCodCargo(Long codCargo) {
		this.codCargo = codCargo;
	}
	
	@Column(name="CARGO_DESCRICAO")
	public String getCargoDescricao() {
		return cargoDescricao;
	}
	public void setCargoDescricao(String cargoDescricao) {
		this.cargoDescricao = cargoDescricao;
	}
	
	
}
