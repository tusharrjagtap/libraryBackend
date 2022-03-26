package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="lab_staff")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Staff extends BaseEntity {
	@Column(length = 30)
	private String first_name;
	
	@Column(length = 30)
	private String middle_name;
	
	@Column(length = 30)
	private String last_name;

	@Column(length = 30)
	private String gender;
	
	@Column(length = 30)
	private String address;
	
	@Column(length=20)
	private long mobile;
	
	@Column(length = 30)
	@Enumerated(EnumType.STRING)
//JsonProperty("department")
	private StaffDept dept;
	
	@Column(length=20)
	private LocalDate dob;
	
	@Column(length=20)
	private LocalDate join_date;
	
	@Column(length=20)
	private double yr_experience;

	@Column(length=20)
	private double salary;
	
	
	@Column(length=20)
	private double bonus;
	
	@Column(length=20)
	private LocalDate leaving_date;
}
