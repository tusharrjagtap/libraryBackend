package com.app.service;

import java.util.List;

import com.app.pojos.Admin;


public interface IAdminService {

	//Admin authenticateAdmin(String email, String password);

	List<Admin> getAll();

	Admin findByEmail(String email);

	

	Admin authenticateAdmin(String email, String password);

	


	
	
	
	
}
