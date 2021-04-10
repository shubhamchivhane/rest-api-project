package com.ecom.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(generator = "user_seq")
	@SequenceGenerator(name = "user_seq",sequenceName = "user_seq_test")
	private int id;
	
	private String name;
	
	

}
