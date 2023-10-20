package com.example.demo.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.ConsultaVO;

public interface ConsultaRespository extends CrudRepository<ConsultaVO, Long> {

}
