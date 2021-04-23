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
	 * Get users by Name, Surname, email
	 * @param User
	 * @return List
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
	 * Update User
	 * @param user
	 */
	public void UpdateUser(User user);
	
	/**
	 * Delete user by ID
	 * @param id
	 */
	public void deleteUserById(String id);
}
