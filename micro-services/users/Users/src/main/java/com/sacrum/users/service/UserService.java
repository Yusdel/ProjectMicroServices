package com.sacrum.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sacrum.users.domain.User;
import com.sacrum.users.repository.UserRepository;

@Service
public class UserService implements IUserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.getAllUsers();
	}

	@Override
	public void InsertUser(User user) {
		userRepository.InsertUser(user);
	}

	@Override
	public User getUserById(String userid) {
		return userRepository.getUserById(userid);
	}

	@Override
	public List<User> getUserByFilter(User user) {
		return userRepository.getUserByFilter(user);
	}

	@Override
	public void UpdateUser(User user) {
		userRepository.UpdateUser(user);
	}

	@Override
	public void deleteUserById(String id) {
		userRepository.deleteUserById(id);
	}
	
}
