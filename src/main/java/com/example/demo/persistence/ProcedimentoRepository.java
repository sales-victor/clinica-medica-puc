package com.example.demo.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.ProcedimentoVO;

public interface ProcedimentoRepository extends CrudRepository<ProcedimentoVO, Long> {

}
