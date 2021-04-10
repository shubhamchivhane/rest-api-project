package com.ecom.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name="cart")
public class Cart {
	
	@Id
	@GeneratedValue(generator = "cart_seq")
	@SequenceGenerator(name = "cart_seq",sequenceName = "cart_seq_test")
	private int id;
	
	@Column(name="quantity")
	private int qty;
	
	@OneToOne
	private User user;
	
	@OneToMany
	private List<Product> product;
	
	@Transient
	public Double getTotalOrderPrice()
	{
		  double sum = 0D;
		 List<Product> list=getProduct();
		 System.out.println(list);
		 for(Product lists : list)
		 {
			 sum+=lists.getPrice();
		 }
		 
		return sum;
	}
	
	@Transient
	public int getTotalOrder()
	{
		return getProduct().size();
	}

}
