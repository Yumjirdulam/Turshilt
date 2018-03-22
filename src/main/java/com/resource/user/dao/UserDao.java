package com.resource.user.dao;

import java.util.List;

import com.resource.user.model.User;

public interface UserDao {

	List<User> getAll();

	long save(User user);

	long update(User user);

	void delete(User user);

	String getAllUsingProcedure();
}
