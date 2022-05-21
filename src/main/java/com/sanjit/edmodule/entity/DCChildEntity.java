package com.sanjit.edmodule.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "dcchildentity")
public class DCChildEntity {
	@Id
	@Column(name="childId")
	private Integer childId;
	
	
	@Column(name = "caseNumber")
	private Integer caseNumber;

	@Column(name = "childName")
	private String childName;
	
	@Column(name = "childAge")
	private Integer childAge;
	
	@Column (name = "childSsn")
	private Integer childSsn;

}
