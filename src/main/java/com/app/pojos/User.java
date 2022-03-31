package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.app.enums.UserType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="lab_user")
@Data

public class User extends BaseEntity  {

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
	
	@Column(name = "num_of_books_present",length = 30)
    private Integer numOfBooksPresent;
    
	@Column(name = "fine",length = 30)
    private Float fine;
	
	@Column(length = 30)
	private String email;
	
	@Column(length = 12)
	private Long addhar;
	
	@Column(length = 30)
	private String password;

	public User() {
		
		// TODO Auto-generated constructor stub
	}

	public User(@Length(min = 4, max = 20, message = "Invalid First Name length!!!!") String first_name,
			@Length(min = 4, max = 20, message = "Invalid Last Name length!!!!") String lastName, String address,
			long mobile, LocalDate dob, UserType role, String collegeId, Integer numOfBooksPresent, Float fine,
			String email, Long addhar, String password) {
		super();
		this.first_name = first_name;
		this.lastName = lastName;
		this.address = address;
		this.mobile = mobile;
		this.dob = dob;
		this.role = role;
		this.collegeId = collegeId;
		this.numOfBooksPresent = numOfBooksPresent;
		this.fine = fine;
		this.email = email;
		this.addhar = addhar;
		this.password = password;
	}
	
	public Float getFine() {
		return fine;
	}

	public void setFine(Float fine) {
		this.fine = fine;
	}



	public String getEmail() {
		return email;
	}

	public Integer getNumOfBooksPresent() {
		return numOfBooksPresent;
	}

	public void setNumOfBooksPresent(Integer numOfBooksPresent) {
		this.numOfBooksPresent = numOfBooksPresent;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getAddhar() {
		return addhar;
	}

	public void setAddhar(Long addhar) {
		this.addhar = addhar;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	
	@Override
	public String toString() {
		return "User [first_name=" + first_name + ", lastName=" + lastName + ", address=" + address + ", mobile="
				+ mobile + ", dob=" + dob + ", role=" + role + ", collegeId=" + collegeId + ", numOfBooksPresent="
				+ numOfBooksPresent + ", fine=" + fine + ", email=" + email + ", addhar=" + addhar + ", password="
				+ password + "]";
	}












	




	
	
	
	
}