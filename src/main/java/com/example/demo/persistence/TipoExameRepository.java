package com.example.demo.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.TipoExameVO;

public interface TipoExameRepository extends CrudRepository<TipoExameVO, Long> {

}
