package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PESSOA")
public class PessoaVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    private Long codPessoa;
    private String nomePessoa;
    private Date dataNascimento;
    private String endereco;
    private String bairro;
    private String cidade;
    private String cep;
    private String telefone;    
    private String cpf;
    
    private PacienteVO pacienteVO;
    private FuncionarioVO funcionarioVO;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="COD_PESSOA")
	public Long getCodPessoa() {
		return codPessoa;
	}
	public void setCodPessoa(Long codPessoa) {
		this.codPessoa = codPessoa;
	}
	
	@Column(name="NOME_PESSOA", nullable = false, length = 100)
	public String getNomePessoa() {
		return nomePessoa;
	}
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}
	
	@Column(name="DATA_NASCIMENTO", nullable = false, length = 20)
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@Column(name="ENDERECO", nullable = false, length = 100)
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	@Column(name="BAIRRO", nullable = false, length = 50)
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	@Column(name="CIDADE", nullable = false, length = 50)
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	@Column(name="CEP", nullable = false, length = 8)
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	@Column(name="TELEFONE", nullable = false, length = 11)
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Column(name="CPF", nullable = false, length = 11)
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	

	@OneToOne(mappedBy = "pessoaVO", fetch = FetchType.EAGER)
	public PacienteVO getPacienteVO() {
		return pacienteVO;
	}
	public void setPacienteVO(PacienteVO pacienteVO) {
		this.pacienteVO = pacienteVO;
	}
	
	@OneToOne(mappedBy = "pessoaVO", fetch = FetchType.EAGER)
	public FuncionarioVO getFuncionarioVO() {
		return funcionarioVO;
	}
	public void setFuncionarioVO(FuncionarioVO funcionarioVO) {
		this.funcionarioVO = funcionarioVO;
	}

}
