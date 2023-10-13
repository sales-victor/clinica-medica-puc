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
@Table(name = "TB_EXAME")
public class ExameVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long codExame;
	private Long codProcedimento;
	private Long codTipoExame;
	private String solicitanteExame;
	
	private TipoExameVO tipoExameVO;
	private ProcedimentoVO procedimentoVO;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="COD_EXAME")
	public Long getCodExame() {
		return codExame;
	}

	public void setCodExame(Long codExame) {
		this.codExame = codExame;
	}

	@Column(name="COD_PROCEDIMENTO")
	public Long getCodProcedimento() {
		return codProcedimento;
	}

	public void setCodProcedimento(Long codProcedimento) {
		this.codProcedimento = codProcedimento;
	}

	@Column(name="COD_TIPO_EXAME")
	public Long getCodTipoExame() {
		return codTipoExame;
	}

	public void setCodTipoExame(Long codTipoExame) {
		this.codTipoExame = codTipoExame;
	}

	@Column(name="SOLICITANTE_EXAME")
	public String getSolicitanteExame() {
		return solicitanteExame;
	}

	public void setSolicitanteExame(String solicitanteExame) {
		this.solicitanteExame = solicitanteExame;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="COD_TIPO_EXAME", referencedColumnName = "COD_TIPO_EXAME", insertable = false, updatable=false)
	public TipoExameVO getTipoExameVO() {
		return tipoExameVO;
	}

	public void setTipoExameVO(TipoExameVO tipoExameVO) {
		this.tipoExameVO = tipoExameVO;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="COD_PROCEDIMENTO", referencedColumnName = "COD_PROCEDIMENTO", insertable = false, updatable=false)
	public ProcedimentoVO getProcedimentoVO() {
		return procedimentoVO;
	}

	public void setProcedimentoVO(ProcedimentoVO procedimentoVO) {
		this.procedimentoVO = procedimentoVO;
	}
	
	
}
