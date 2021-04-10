package com.ecom.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.exception.UserNotFoundException;
import com.ecom.model.User;
import com.ecom.repository.UserRepository;
import com.ecom.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;
	
	@Override
	public User saveUser(User user) {
		
		return repo.save(user);
	}

	@Override
	public Optional<User> getUser(int id) {
		Optional<User> user= repo.findById(id);
		if(user == null)
		{
			throw new UserNotFoundException("User Not Found With id :"+id);
		}
		return repo.findById(id);
	}

	@Override
	public List<User> getAllUser() {
		
		return repo.findAll();
	}

}
