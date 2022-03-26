package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.ILoginUService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/userlogin")
public class LoginUController {
	@Autowired
	private ILoginUService loginUService;
}
