package com.sanjit.edmodule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanjit.edmodule.entity.DCChildEntity;



public interface ChildRepo extends JpaRepository<DCChildEntity, Integer> {

	List<DCChildEntity> findByCaseNumber(Integer cnum);

	

}
