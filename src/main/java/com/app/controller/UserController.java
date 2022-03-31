package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.pojos.User;
import com.app.service.IUserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {
//	//dependency : service layer i/f
	@Autowired
	private IUserService userService;
	
	public UserController() {
		System.out.println("in ctor of " + getClass());
	}
	//add request handling method to send all emps to the caller(front end) : getting resources : GET
//	@GetMapping
//	public List<User> getAllUserDetails()
//	{
//		System.out.println("in get all user");
//		return userService.getAll();
//	}
	@GetMapping
	public ResponseEntity<?> getAllUserDetails()
	{
		System.out.println("in get all users");
	return new ResponseEntity <> (userService.getAll(),HttpStatus.OK) ;
	}
	//add request handling method to insert new emp detaild(create a new resource) : POST
	@PostMapping
	public User addUserDetails(@RequestBody  User e) //de-serial (un marshalling)
	{
		
		System.out.println("in add User "+e);
		return userService.addOrUpdateUserDetails(e);
	}
	//add request handling method to delete emp details by emp id
	//Request URL  sent by front end : http://host:port/api/Users/1234 , method=DELETE
	@DeleteMapping("/{id}")
	public String deleteUserDetails(@PathVariable int id)
		{
	System.out.println("in del user dtls "+id);
		return userService.deleteUserDetails(id);
	}
//	//add req handling method to get selected emp details by id.
//	//URL : http://host:port/api/Users/1234 , method=GET
	@GetMapping("/{userId}")
	public ResponseEntity<?> getUserDetails(@PathVariable int userId)
	{
		System.out.println("in get user dtls "+userId);
//		//invoke service layer's method
		try {
			// invoke service layer's method
			return new ResponseEntity<>(userService.fetchUserDetails(userId), HttpStatus.OK);
		}catch (Exception e) {
			System.out.println("err in get user dtls"+e);
			return new ResponseEntity<> (e.getMessage(),HttpStatus.NOT_FOUND);
			
			
		}
//
	}
	
	
	//add request handling method to update existing emp details (update a  resource) : PUT
		@PutMapping
		public User updateUserDetails(@RequestBody  User e) //de-serial (un marshalling) 
		{
			//e : DETACHED POJO , containing updated state
			System.out.println("in putmapping user "+e);
			return userService.addOrUpdateUserDetails(e);
	}
}
