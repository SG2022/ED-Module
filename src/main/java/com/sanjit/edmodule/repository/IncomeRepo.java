package com.sanjit.edmodule.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sanjit.edmodule.entity.DCIncome;
import com.sanjit.edmodule.entity.DCPlans;



@Repository
public interface IncomeRepo extends JpaRepository<DCIncome, Integer> {

	Optional<DCIncome> findByCaseNumber(Integer cnum);

}
