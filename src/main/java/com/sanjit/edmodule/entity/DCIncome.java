package com.sanjit.edmodule.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="dcincome")
public class DCIncome {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "incomeId")
	private Integer incomeId;

	@Column(name="caseNumber")
	private Integer caseNumber;
	
	@Column(name="salaryIncome")
	private Double salaryIncome;
	
	@Column(name="propertyIncome")
	private Double propertyIncome;
	
	@Column(name="rentIncome")
	private Double rentIncome;




}
