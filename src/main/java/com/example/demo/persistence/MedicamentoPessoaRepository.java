package com.example.demo.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.MedicamentoPessoaVO;

public interface MedicamentoPessoaRepository extends CrudRepository<MedicamentoPessoaVO, Long> {
	
	List<MedicamentoPessoaVO> findByCodPaciente(Long codPaciente);

}
