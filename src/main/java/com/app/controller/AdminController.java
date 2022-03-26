package com.app.controller;

import javax.servlet.http.HttpSession;

import com.app.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Admin;
import com.app.pojos.Role;
import com.app.pojos.User;

import com.app.service.IAdminService;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private IAdminService adminService;
	public AdminController() {
		System.out.println("in ctor of " + getClass());
	}
	
	@GetMapping
	public ResponseEntity<?> getAllAdminDetails()
	{
		System.out.println("in get all users");
	return new ResponseEntity <> (adminService.getAll(),HttpStatus.OK) ;
	}
	
	@GetMapping("/login")
	public String showLoginFrom() {
		System.out.println("in show login form");
		return "/admin/login";// AVN : /WEB-INF/views/user/login.jsp
	}
	@PostMapping("/login") // @RequestMapping + method=POST
	public String processLoginForm(@RequestParam String email, @RequestParam String password, Model map,
			HttpSession session) {
		System.out.println(" in login page ...............");
		System.out.println("in process login form " + email + " " + password + " " + map);
		try {
			// controller has to invoke service layer method --for exec of B.L
			
			Admin admin = adminService.authenticateAdmin(email, password);// in case of success : DETACHED pojo
			// in case of invalid login :
			System.out.println("login successful...............");
			// => valid login
			// add validated user details , under Model map
			session.setAttribute("admin_details", admin);
			if (admin.getRole() == Role.ADMIN) {
				// invoke topic service method to get list of all topics --save it in Model map
				// .
				System.out.println("login successful...............");
				// map.addAttribute("topic_list", topicService.getAllTopics());
				return "redirect:/admin/welcome";// UserController sends to D.S : redirect view name
				// skips V.R ,
				// response.sendRedirect(response.encodeRedirectURL("customer/topics"));
				// sends temp resp pkt : SC 302 | Location : customer/topics , set-cookie :
				// JSESSIONID : dfgsdf546735, | Body : EMPTY
				// clnt browser : sends new request :
				// http://host:port/day16_spring_mvc/customer/topics
			}
			System.out.println("login successful...............");
			// admin login :
			return "/admin/authenticateAdmin";// redirect view name , D.S skips  V.R --sends temp redirect resp
			//next request will be sent form clnt browser : http://host:port/spring-mvc-boot/admin/welcome
			//method = GET

		} catch (RuntimeException e) {
			System.out.println("err in class " + getClass() + "in  process login form " + e);// NoResultExc
			// add err mesg in the model map
			map.addAttribute("message", "Invalid Login , Please retry.....");
			return "/admin/login";// in case of invalid login ---> forward clnt to login page + err mesg
			// implicitly : map --model attr : message
		}

	}

	@PostMapping("/admin/authenticateAdmin")
	public ResponseEntity<?> authenticateAdmin(Admin admin,HttpSession session) {

		Admin authadmin = adminService.findByEmail(admin.getEmail());

		
		if(authadmin!=null && authadmin.getRole().equals("ADMIN") ){
			if(authadmin.getPassword().equals(admin.getPassword()) ){
				
				return Response.success(authadmin);
			}
		}else if(authadmin!=null && authadmin.getRole().equals("STAFF") ){
			if(authadmin.getPassword().equals(admin.getPassword()) ){
				
				return Response.success(authadmin);
			}
		}else if(authadmin!=null && authadmin.getRole().equals("STUDENT") ){
			if(authadmin.getPassword().equals(admin.getPassword()) ){
				
				return Response.success(authadmin);
			}
		}	
		return Response.error("404");
	}

}
