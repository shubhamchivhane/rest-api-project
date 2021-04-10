package com.ecom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="product_tbl")
public class Product {

	
	@Id
	@GeneratedValue(generator = "product_seq")
	@SequenceGenerator(name = "product_seq",sequenceName = "product_seq_test")
	private int id;
	
	private String name;
	
	private Double price;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	Category category;
	
}
