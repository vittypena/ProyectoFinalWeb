package com.patronDto.app.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CustomerDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4166051642525913367L;

	private Long id;
	private String FullName;
	private String country;
	private String address;
	private String zipCode;
	private String email;
	private Integer numeroMuertes;
	private Integer enemigosFantasmaDerrotados;
	private Integer enemigosEsqueletosDerrotados;
	private Integer enemigosBestiaDerrotados;
	private Integer bossFinalDerrotados;
	private Integer monedasObtenidas;
	private Boolean nivelSecreto;
}
