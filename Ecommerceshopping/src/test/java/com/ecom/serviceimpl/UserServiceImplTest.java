package com.ecom.serviceimpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;
import static org.mockito.ArgumentMatchers.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.assertj.core.api.Assert;
import static org.junit.jupiter.api.Assertions.*;

import com.ecom.exception.UserNotFoundException;
import com.ecom.model.User;
import com.ecom.repository.UserRepository;

class UserServiceImplTest {

	@Mock
	UserRepository repo;
	
	@InjectMocks
	UserServiceImpl service;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}


	@Test
	final void testGetUser() {
		//fail("Not yet implemented");
		
		User user=new User();
		user.setId(0);
		user.setName("shubham");
		
		Optional<User> usr=Optional.of(user);
		
		
		when(repo.findById(anyInt())).thenReturn(usr);
		
		Optional<User> usrs=service.getUser(0);
		assertThat(usrs).isNotNull();
		assertEquals("shubham", usrs.get().getName());

	}
	
	@Test
	final void testSaveUser()
	{
		User user=new User();
		user.setId(0);
		user.setName("shubham");
		
		when(repo.save(user)).thenReturn(user);
		User customer=service.saveUser(user);
		assertNotNull(customer);
		assertEquals(user.getName(), customer.getName());
	}

	@Test
	final void testGetUser_UserNotFoundException()
	{
		when(repo.findById(0)).thenReturn(null);
		assertThrows(UserNotFoundException.class, 
				() ->
		{
			service.getUser(0).get();
		}
				);
	}

}
