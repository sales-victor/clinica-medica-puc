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
@Table(name = "TB_PAGAMENTO")
public class PagamentoVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long codPagamento;
	private Long codProcedimento;
	private String formaDePagamento;
	private Double valorPagamento;
	private Long codConfirmacao;
	private String estadoPagamento;
	
	private ProcedimentoVO procedimentoVO;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="COD_PAGAMENTO")
	public Long getCodPagamento() {
		return codPagamento;
	}

	public void setCodPagamento(Long codPagamento) {
		this.codPagamento = codPagamento;
	}
	
	@Column(name="COD_PROCEDIMENTO")
	public Long getCodProcedimento() {
		return codProcedimento;
	}

	public void setCodProcedimento(Long codProcedimento) {
		this.codProcedimento = codProcedimento;
	}
	
	@Column(name="FORMA_DE_PAGAMENTO")
	public String getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	@Column(name="VALOR_PAGAMENTO")
	public Double getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(Double valorPagamento) {
		this.valorPagamento = valorPagamento;
	}

	@Column(name="COD_CONFIRMACAO")
	public Long getCodConfirmacao() {
		return codConfirmacao;
	}

	public void setCodConfirmacao(Long codConfirmacao) {
		this.codConfirmacao = codConfirmacao;
	}
	
	@Column(name="ESTADO_PAGAMENTO")
	public String getEstadoPagamento() {
		return estadoPagamento;
	}

	public void setEstadoPagamento(String estadoPagamento) {
		this.estadoPagamento = estadoPagamento;
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
