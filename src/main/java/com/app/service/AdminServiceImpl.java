package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.AdminRepository;
import com.app.pojos.Admin;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {
	@Autowired 
	private AdminRepository adminRepo;

	
	@Override
	public Admin authenticate(String email, String password) {
		Admin admin = findByEmail(email);
		if(admin != null && admin.getPassword().equals(password))
		   return admin;
		return null;
	}

	@Override
	public Admin findByEmail(String email) {
		return adminRepo.findByEmail(email);
	}
	@Override
	public List<Admin> getAll() {
		// TODO Auto-generated method stub
		return adminRepo.findAll();
	}

	


	//after service layer method rets(i.e after @Transactional method rets : tx over --commit(no excs) | rollback (excs) 
	//L1 cache is destroyed --pooled out db cn rets to the pool --hib session is closed 


	
	
}
