package com.sanjit.edmodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanjit.edmodule.entity.EDDetailsTb;

public interface EDModuleRepo extends JpaRepository<EDDetailsTb, Integer> {
	

}
