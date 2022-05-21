package com.sanjit.edmodule.entity;



import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Data;

@Entity
@Data

@Table(name ="AppRegTb")
public class ApplicantDetails {
	@Id
	@Column(name = "appNum")
	private Integer appNum;
	
	@Column(name = "fullName")
	private String fullName;
	
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="dob")
	private LocalDate dob;
	
	@Column(name="ssn")
	private String ssn;
	
}
	
	
	