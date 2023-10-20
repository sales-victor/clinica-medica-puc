package com.example.demo.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.MedicamentoVO;

public interface MedicamentoRepository extends CrudRepository<MedicamentoVO, Long> {

}
