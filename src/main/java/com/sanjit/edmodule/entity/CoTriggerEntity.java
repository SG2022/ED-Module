package com.sanjit.edmodule.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "cotrigger")
public class CoTriggerEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "coTrigId")
	private Integer CoTrigId;
	
	@Column(name="caseNumber")
	private Integer caseNumber;
	
	@Column(name="coPdf")
	private byte[] coPdf;
	
	@Column(name="trgStatus")
	private String trgStatus;

}
