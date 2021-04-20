package com.sacrum.users.service;

import java.util.List;

import com.sacrum.users.domain.User;

public interface IUserService {
	
	/**
	 * 
	 * @return
	 */
	List<User> getAllUsers();
	
	/**
	 * 
	 * @param userid
	 * @return
	 */
	User getUserById(String userid);
	
	/**
	 * 
	 * @param user
	 */
	void InsertUser(User user);
	
}
