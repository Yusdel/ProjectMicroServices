package com.sacrum.users.repository;

import java.util.List;

import com.sacrum.users.domain.User;

/**
 * @author Yusdel Morales Guevara
 *
 */
public interface IUserRepository {
	
	/**
	 * Select Single User
	 * @param id
	 * @return
	 */
	public User getUserById(String id);
	
	/**
	 * Read all users
	 * @return List<User>
	 */
	public List<User> getAllUsers();
	
	/**
	 * Create new User or Modify User
	 * @param user
	 */
	public void InsertUser(User user);
	
	/**
	 * Delete user by ID
	 * @param id
	 */
	public void deleteUserById(String id);
}
