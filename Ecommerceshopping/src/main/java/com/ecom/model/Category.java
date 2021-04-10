package com.ecom.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="category")
public class Category {
	
	
	@Id
	@GeneratedValue(generator = "category_seq")
	@SequenceGenerator(name = "category_seq",sequenceName = "category_seq_test")
	private int id;
	
	private String name;
	
	
}
