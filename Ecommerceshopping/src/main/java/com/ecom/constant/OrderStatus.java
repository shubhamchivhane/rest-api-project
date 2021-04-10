package com.ecom.constant;

public enum OrderStatus {

	 ORDERED("ORDERED"),CANCELLED("CANCELLED");
	
	private String value;

	private OrderStatus(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	
}
