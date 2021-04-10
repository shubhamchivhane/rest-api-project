package com.ecom.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.ecom.constant.OrderStatus;

import lombok.Data;

@Data
@Entity
@Table(name = "order_tbl")
public class Order {

	@Id
	@GeneratedValue(generator = "order_seq")
	@SequenceGenerator(name = "order_seq",sequenceName = "order_seq_test")
	private int id;

	@Column(name = "total_price")
	private Double totalPrice;

	@Column(name = "created_date")
	private Date createdDate=new Date();

	@LastModifiedDate
	@Column(name = "last_modified_date")
	private Date lastModifiedDate;

	@Column(name = "confirmation")
	private String isOrderConfirm;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="user_id")
	User user;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="cart_id")
	private Cart cart;
}
