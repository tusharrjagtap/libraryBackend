package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.LoginURepository;

@Service
@Transactional
public class LoginUServiceImpl implements ILoginUService{

	@Autowired 
	private LoginURepository loginURepo;
}
