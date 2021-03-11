package com.indra.crud.service;

import java.util.List;

import com.indra.crud.model.User;

public interface UserService {
	String insertUser(User user);
	List<User> searchAllUsers();
	User searchUser(User user);
	Boolean updateUser(User user);
	Boolean deleteUser(User user);
}
