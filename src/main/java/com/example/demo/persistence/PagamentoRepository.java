package com.example.demo.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.PagamentoVO;

public interface PagamentoRepository extends CrudRepository<PagamentoVO, Long> {

}
