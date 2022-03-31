package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.UserRepository;
import com.app.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	//dependency : dao layer i/f
	@Autowired
	private UserRepository userRepo;

	@Override
	public List<User> getAll() {
		// Method of JpaRepository : super i/f dao layer i/f
		//Inherited API : public List<T> findAll();
		return userRepo.findAll();
	}

	@Override
	public User addOrUpdateUserDetails(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
		//CrudRepository Methd : save(T entity)
		//Checks if id == null => transient entity , will fire insert upon commit
		//if id != null => detached entity , will fire update upon commit
	}// what will method ret ? DETACHED emp ---> to the controller

	@Override
	public String deleteUserDetails(int id) {
		// service layer invokes dao's method
		userRepo.deleteById(id);
		return "User Details with ID " + id + " deleted successfuly... ";
	}

	@Override
	public User fetchUserDetails(int userId) {
		// invoke dao's method
		// Optional<Employee> optional = employeeRepo.findById(empId);
		return userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Emp by ID " + userId + " not found!!!!"));
	}

}
