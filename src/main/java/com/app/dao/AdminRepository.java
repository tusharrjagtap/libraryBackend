package com.app.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Admin;


public interface AdminRepository extends JpaRepository<Admin, String> {

	Object findByEmailAndPassword(String email, String password);

	Admin findByEmail(String email);






	

	
	

}
