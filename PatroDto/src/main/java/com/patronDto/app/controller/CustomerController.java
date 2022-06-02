package com.patronDto.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patronDto.app.dto.CustomerDTO;
import com.patronDto.app.entity.AddressEntity;
import com.patronDto.app.entity.CustomerEntity;
import com.patronDto.app.entity.PartidaEntity;
import com.patronDto.app.provider.ICustomerProvider;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	private ICustomerProvider customerProvider;
	
	@GetMapping("/customers/{idCustomer}")
	public ResponseEntity<?> showCustomerDTO(@PathVariable Long idCustomer){
		
		Optional<CustomerEntity> customerEntity = customerProvider.findById(idCustomer);
		AddressEntity addressEntity = customerProvider.findAddressByCostumer(customerEntity.get());
		PartidaEntity partidaEntity = customerProvider.findPartidaByCostumer(customerEntity.get()); 
		
		//Rellenamos el customerDto que retornaremos
		CustomerDTO customerDto = new CustomerDTO();
		customerDto.setAddress(addressEntity.getAddress());
		customerDto.setCountry(addressEntity.getCountry());
		customerDto.setZipCode(addressEntity.getZipCode());
		customerDto.setFullName(customerEntity.get().getFirstName().concat(" ").concat(customerEntity.get().getLastName()));
		customerDto.setId(customerEntity.get().getId());
		customerDto.setNumeroMuertes(partidaEntity.getNumeroMuertes());
		customerDto.setEnemigosFantasmaDerrotados(partidaEntity.getEnemigosFantasmaDerrotados());
		customerDto.setEnemigosEsqueletosDerrotados(partidaEntity.getEnemigosEsqueletosDerrotados());
		customerDto.setEnemigosBestiaDerrotados(partidaEntity.getEnemigosBestiaDerrotados());
		customerDto.setBossFinalDerrotados(partidaEntity.getBossFinalDerrotados());
		customerDto.setMonedasObtenidas(partidaEntity.getMonedasObtenidas());
		customerDto.setNivelSecreto(partidaEntity.getNivelSecreto());
		
		return new ResponseEntity<CustomerDTO>(customerDto, HttpStatus.OK);
	}
}
