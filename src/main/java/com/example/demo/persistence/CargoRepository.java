package com.example.demo.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.CargoVO;

public interface CargoRepository extends CrudRepository<CargoVO, Long> {

}
