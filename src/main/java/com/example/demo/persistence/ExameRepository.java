package com.example.demo.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.ExameVO;

public interface ExameRepository extends CrudRepository<ExameVO, Long> {

}
