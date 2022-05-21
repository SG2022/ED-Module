package com.sanjit.edmodule.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="EdDetailsTb")
public class EDDetailsTb {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "edTraceId")
	private Integer edTraceId  ;
	
	@Column(name = "caseNum")
    private	Integer caseNum;
	
	@Column(name = "holderName")
	private String holderName;
	
	@Column(name = "holderSSn")
	private String holderSSn;
	
	@Column(name = "planName")
	private String planName;
	
	@Column(name = "planStatus")
	private String planStatus;
	
	@Column(name = "startDate")
	private Date startDate;
	
	@Column(name = "endDate")
	private Date endDate;
	
	@Column(name = "benefitAmt")
	private Double benefitAmt;
	
	@Column(name = "denialReason")
	private String denialReason;

}

/*
 ED_ELIG_DTLS
-------------
ED_TRACE_ID  PK
CASE_NUM
HOLDER_NAME
HOLDER_SSN
PLAN_NAME
PLAN_STATUS
PLAN_START_DATE
PLAN_END_DATE
BENEFIT_AMT
DENIAL_REASON
 */
