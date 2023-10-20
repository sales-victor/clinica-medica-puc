package com.example.demo.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.PrescricaoVO;

public interface PrescricaoRepository extends CrudRepository<PrescricaoVO, Long> {

}
