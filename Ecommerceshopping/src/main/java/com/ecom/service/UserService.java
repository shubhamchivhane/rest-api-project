package com.ecom.service;

import java.util.List;
import java.util.Optional;

import com.ecom.model.User;

public interface UserService {

	User saveUser(User user);
	Optional<User> getUser(int id);
	List<User> getAllUser();
}
