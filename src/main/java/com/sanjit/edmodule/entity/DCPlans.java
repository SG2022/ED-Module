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
@Table(name = "dcplans")
public class DCPlans {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "planId")
	private Integer planId;
	
	@Column(name = "caseNumber")
	private Integer caseNumber;
	
	@Column(name = "planName")
	private String planName;

}
