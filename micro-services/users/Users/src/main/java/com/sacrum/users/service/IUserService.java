package com.sacrum.users.service;

import java.util.List;

import com.sacrum.users.domain.User;

public interface IUserService {
	List<User> getAllUsers();
	void InsertUser(User user);
}
