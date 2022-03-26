package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="admin")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin extends BaseEntity{
	@Column(length = 30)
	private String first_name;
	
	@Column(length = 30)
	private String middle_name;
	
	@Column(length = 30)
	private String last_name;

	@Column(length = 30)
	private String email;
	
	@Column(length = 12)
	private long addhar;
	
	@Column(length = 30)
	private String username;
	
	@Column(length = 30)
	private String password;
	
	@Column(length = 10)
	private long mobile;
	
	@Enumerated(EnumType.STRING)
	private Role role;

	
	
}
