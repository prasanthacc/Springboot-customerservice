package com.customer.ms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "custserv")
public class CustomerM {

	@Id
	private String cusId;
	private String cusName;
	private String address;
	
	public CustomerM(String cusId, String cusName, String address) {
		
		this.cusId = cusId;
		this.cusName= cusName;
		this.address = address;
			}
	
	
	public String getCusId() {
		return cusId;
	}
	public void setCusId(String cusId1) {
		this.cusId = cusId1;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
