package com.ecom.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ecom.model.Category;
import com.ecom.model.Product;
import com.ecom.repository.ProductRepository;

class ProductServiceImplTest {

	@InjectMocks
	ProductServiceImpl service;

	@Mock
	ProductRepository repo;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testSaveProduct() {
		Category c = new Category();
		c.setId(1);
		c.setName("Mobiles");
		Product p = new Product();
		p.setId(1);
		p.setName("MI 12S");
		p.setPrice(16000.00);
		p.setCategory(c);
		
		when(repo.save(p)).thenReturn(p);
		
		Product savedProduct=service.saveProduct(p);

		assertNotNull(savedProduct);
		assertEquals(savedProduct.getName(), p.getName());
		assertEquals(savedProduct.getCategory().getName(), "Mobiles");
	}

	@Test
	void testGetProduct() {
		Category c = new Category();
		c.setId(1);
		c.setName("Mobiles");
		Product p = new Product();
		p.setId(1);
		p.setName("MI 12S");
		p.setPrice(16000.00);
		p.setCategory(c);
		
		Optional<Product> prod=Optional.of(p);
		
		when(repo.findById(anyInt())).thenReturn(prod);
		Optional<Product> prods=service.getProduct(anyInt());
		assertNotNull(prods);
		assertEquals(prod.get().getName(), prods.get().getName());
	}

	@Test
	void testGetAllProduct() {
		
		when(repo.findAll()).thenReturn(getAllList());
		List<Product> list=service.getAllProduct();
		assertNotNull(list);
		assertEquals(2, list.size());
		
	}
	
	List<Product> getAllList()
	{
		Category c = new Category();
		c.setId(1);
		c.setName("Mobiles");
		Product p = new Product();
		p.setId(1);
		p.setName("MI 12S");
		p.setPrice(16000.00);
		p.setCategory(c);
		Product p1 = new Product();
		p1.setId(1);
		p1.setName("MI 12S");
		p1.setPrice(16000.00);
		p1.setCategory(c);

		List<Product> list=new ArrayList<>();
		list.add(p);
		list.add(p1);
		return list;
	}

}
