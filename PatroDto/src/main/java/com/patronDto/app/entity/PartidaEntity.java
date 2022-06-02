package com.patronDto.app.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="partida")
public class PartidaEntity{
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;	
	
	@OneToOne
	@JoinColumn(name = "fk_customer")
	private CustomerEntity customer;
	
	@Column(name = "numeroMuertes")
	private Integer numeroMuertes;
	
	@Column(name = "enemigosFantasmaDerrotados")
	private Integer enemigosFantasmaDerrotados;
	
	@Column(name = "enemigosEsqueletosDerrotados")
	private Integer enemigosEsqueletosDerrotados;
	
	@Column(name = "enemigosBestiaDerrotados")
	private Integer enemigosBestiaDerrotados;
	
	@Column(name = "bossFinalDerrotados")
	private Integer bossFinalDerrotados;
	
	@Column(name = "monedasObtenidas")
	private Integer monedasObtenidas;
	
	@Column(name = "nivelSecreto")
	private Boolean nivelSecreto;		
}
