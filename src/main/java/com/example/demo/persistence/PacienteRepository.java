package com.example.demo.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.PacienteVO;

public interface PacienteRepository extends CrudRepository<PacienteVO, Long> {
	PacienteVO findByCodPessoa(Long codPessoa);
}
