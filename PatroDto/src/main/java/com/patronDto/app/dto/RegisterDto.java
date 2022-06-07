package com.patronDto.app.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class RegisterDto implements Serializable {

	private static final long serialVersionUID = -4166051642525913367L;
	private String password;
	private String email;
	private String name;
	private String lastName;
	private String apellido;
	private String country;
	private String address;
	private String zipCode;	
}
