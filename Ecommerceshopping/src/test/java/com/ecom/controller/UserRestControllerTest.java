package com.ecom.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;
import com.ecom.model.User;
import com.ecom.serviceimpl.UserServiceImpl;

class UserRestControllerTest {

	@InjectMocks
	UserRestController controller;

	@Mock
	UserServiceImpl service;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testAddCategory() {

		User user = new User();
		user.setId(0);
		user.setName("Aditi");

		Mockito.when(service.saveUser(user)).thenReturn(user);
		ResponseEntity<User> data = controller.addCategory(user);
		System.out.println(data);
		String status = data.getStatusCode().toString();
		String usr = data.getBody().toString();
		System.out.println(usr);
		assertEquals(status, "201 CREATED");

	}

}
