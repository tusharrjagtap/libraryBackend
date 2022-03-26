package com.app.service;

import java.util.List;

import com.app.pojos.User;

public interface IUserService {
	List<User> getAll();
	User addOrUpdateUserDetails(User transientUser);
	String deleteUserDetails(int id);
	User fetchUserDetails(int userId);
}
