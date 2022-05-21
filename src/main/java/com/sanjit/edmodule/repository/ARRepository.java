package com.sanjit.edmodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanjit.edmodule.entity.ApplicantDetails;

public interface ARRepository extends JpaRepository<ApplicantDetails, Integer> {

}
