package com.patronDto.app.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UsuarioDto implements Serializable {
	private static final long serialVersionUID = -4166051642525913267L;
	
	private Long id;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
}
