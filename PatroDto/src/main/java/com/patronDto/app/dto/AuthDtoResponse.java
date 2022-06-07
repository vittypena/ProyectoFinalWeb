package com.patronDto.app.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AuthDtoResponse implements Serializable {
	
	private static final long serialVersionUID = -4166051642525913367L;

	private String email;
	private String fullName;
	boolean validado;
}