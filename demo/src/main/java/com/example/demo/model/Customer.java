package com.example.demo.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class Customer implements java.io.Serializable {

	private int id;
	@NotBlank
	@Length(max = 20)
	private String name;
	@NotBlank
	@Length(max = 100)
	private String address;
	@NotBlank
	@Email
	private String emailAddress;

	public Customer(String name, String address, String emailAddress) {
		this.name = name;
		this.address = address;
		this.emailAddress = emailAddress;
	}

	public boolean isNgEmail() {
		//ng.foo.bazは使用不可のアドレスとみなす
		return emailAddress.matches(".*@ng.foo.baz");
	}

	public boolean isFreeEmail() {
		//free.foo.bazはフリーメールとみなす
		return emailAddress.matches(".*@free.foo.baz");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return String.format("Customer [id=%s, name=%s, address=%s, emailAddress=%s]", id, name, address, emailAddress);
	}


}
