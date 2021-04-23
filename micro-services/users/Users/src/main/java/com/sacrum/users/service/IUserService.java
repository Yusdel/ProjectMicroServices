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
	 * check user by Id or Name and Surname
	 * @param user
	 * @return
	 */
	List<User> getUserByFilter(User user);
	
	/**
	 * Create new User
	 * @param user
	 */
	void InsertUser(User user);
	
	/**
	 * Update User
	 * @param user
	 */
	void UpdateUser(User user);
	
	/**
	 * Delete user by ID
	 * @param id
	 */
	public void deleteUserById(String id);
}
