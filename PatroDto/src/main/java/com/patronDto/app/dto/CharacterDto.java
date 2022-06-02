package com.patronDto.app.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CharacterDto implements Serializable {

	
	private static final long serialVersionUID = -4166051642525913367L;

	private Long id;
	private String nombre;
	private String frase;
	private String descripcion;
	private String rutaImagen;
}
