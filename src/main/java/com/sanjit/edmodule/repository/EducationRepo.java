package com.sanjit.edmodule.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanjit.edmodule.entity.DCEducation;
import com.sanjit.edmodule.entity.DCPlans;






public interface EducationRepo extends JpaRepository<DCEducation, Integer> {

	Optional<DCEducation> findByCaseNumber(Integer cnum);

}
