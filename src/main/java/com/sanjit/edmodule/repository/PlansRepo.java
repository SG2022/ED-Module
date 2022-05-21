package com.sanjit.edmodule.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sanjit.edmodule.entity.ApplicantDetails;
import com.sanjit.edmodule.entity.DCPlans;



@Repository
public interface PlansRepo extends JpaRepository<DCPlans, Integer> {

	Optional<DCPlans> findByCaseNumber(Integer cnum);
	
	

}
