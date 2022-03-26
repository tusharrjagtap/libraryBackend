package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="lab_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity  {

//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="uid",nullable = false)
//	private LoginU fk_uid;
	
	//name,email,password, address, aadhar,mobile, id
	//@NotEmpty(message ="First Name can't be blank")
	@Length(min = 4,max=20,message = "Invalid First Name length!!!!")
	@Column(length = 30)
	private String first_name;
	
	@Column(length = 20)
	//@NotEmpty(message ="Last Name can't be blank")
	@Length(min = 4,max=20,message = "Invalid Last Name length!!!!")	
	private String lastName;
	
	@Column(length = 60)
	//@NotEmpty(message="location must be supplied")
	private String address;
	
	@Column(length = 10)
	private long mobile;
	
	//@NotEmpty(message = "date of birthday must be Enter....")
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;

	@Enumerated(EnumType.STRING)
	private UserType role;
	
	@Column(length = 30)
	//@NotEmpty(message="College ID must be supplied")
	private String collegeId;
	

	
//	@Id
//	//dont generate id automatically
//	@Column(name="book_bankId")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private String book_bankId;
	
	

//	@Column(length = 30)
//	private String email;
//	
//	@Column(length = 12)
//	private long addhar;
//	
//	@Column(length = 30)
//	private String password;
	
	
	
	
}