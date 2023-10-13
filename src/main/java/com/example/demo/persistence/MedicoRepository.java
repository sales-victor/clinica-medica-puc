package com.example.demo.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.MedicoVO;

public interface MedicoRepository extends CrudRepository<MedicoVO, Long> {

}
