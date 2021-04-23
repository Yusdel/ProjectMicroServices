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
	 * @return user or null
	 */
	public User getUserById(Long id);
	
	/**
	 * Get users by Name, Surname, email
	 * @param
	 * @return List of user or null
	 */
	public List<User> getUserByFilter(User user);
	
	/**
	 * Read all users
	 * @return List<User>
	 */
	public List<User> getAllUsers();
	
	/**
	 * Create new User
	 * @param user
	 */
	public void InsertUser(User user);
	
	/**
	 * 
	 * @param user
	 * @return > 0 = done, -1 error
	 */
	public int UpdateUser(User user);
	
	/**
	 * Delete user by ID
	 * @param id
	 */
	public void deleteUserById(String id);
}
