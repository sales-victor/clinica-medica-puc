package com.example.demo.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.FuncionarioVO;

public interface FuncionarioRepository extends CrudRepository<FuncionarioVO, Long> {

}
