package com.example.demo.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.PessoaVO;

public interface PessoaRepository extends CrudRepository<PessoaVO, Long> {
	
	@Query("SELECT pessoaVO FROM MedicoVO medicoVO JOIN FuncionarioVO funcionarioVO ON medicoVO.codFuncionario = funcionarioVO.codFuncionario JOIN PessoaVO pessoaVO ON funcionarioVO.codPessoa = pessoaVO.codPessoa WHERE medicoVO.codMedico = :codMedico")
	PessoaVO findByDadosMedico(Long codMedico);

}
