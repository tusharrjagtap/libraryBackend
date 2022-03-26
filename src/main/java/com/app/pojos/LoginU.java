package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user_login")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginU extends BaseEntity {

	@Column(length = 30)
	private String email;
	
	@Column(length = 12)
	private long addhar;
	
	@Column(length = 30)
	private String password;
	
}
