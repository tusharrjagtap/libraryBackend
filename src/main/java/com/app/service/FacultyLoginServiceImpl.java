package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.FacultyLoginRepository;

@Service
@Transactional
public class FacultyLoginServiceImpl implements IFacultyLoginService {

	@Autowired
	private FacultyLoginRepository facultyLoginRepo;
}
