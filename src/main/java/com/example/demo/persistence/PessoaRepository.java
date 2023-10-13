package com.example.demo.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.PessoaVO;

public interface PessoaRepository extends CrudRepository<PessoaVO, Long> {

}
