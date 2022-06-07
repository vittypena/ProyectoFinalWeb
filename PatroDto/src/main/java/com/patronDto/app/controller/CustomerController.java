package com.patronDto.app.controller;


import java.util.Optional;

import javax.persistence.Column;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patronDto.app.dao.IAddressRepository;
import com.patronDto.app.dao.ICustomerRepository;
import com.patronDto.app.dto.AuthDto;
import com.patronDto.app.dto.AuthDtoResponse;
import com.patronDto.app.dto.CustomerDTO;
import com.patronDto.app.dto.RegisterDto;
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
	
	@Autowired
	private ICustomerRepository customerRepository;
	
	@Autowired
	private IAddressRepository addressRepository;
	
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
		customerDto.setEmail(customerEntity.get().getEmail());
		customerDto.setNumeroMuertes(partidaEntity.getNumeroMuertes());
		customerDto.setEnemigosFantasmaDerrotados(partidaEntity.getEnemigosFantasmaDerrotados());
		customerDto.setEnemigosEsqueletosDerrotados(partidaEntity.getEnemigosEsqueletosDerrotados());
		customerDto.setEnemigosBestiaDerrotados(partidaEntity.getEnemigosBestiaDerrotados());
		customerDto.setBossFinalDerrotados(partidaEntity.getBossFinalDerrotados());
		customerDto.setMonedasObtenidas(partidaEntity.getMonedasObtenidas());
		customerDto.setNivelSecreto(partidaEntity.getNivelSecreto());
		
		return new ResponseEntity<CustomerDTO>(customerDto, HttpStatus.OK);
	}
	
	@PostMapping("/customers")
	public ResponseEntity<CustomerDTO> infoCustomer(@RequestBody AuthDto customer){
		
		CustomerEntity customerEntity = customerProvider.findByEmail(customer.getEmail());
		AddressEntity addressEntity = customerProvider.findAddressByCostumer(customerEntity);
		PartidaEntity partidaEntity = customerProvider.findPartidaByCostumer(customerEntity); 
		
		//Rellenamos el customerDto que retornaremos
		CustomerDTO customerDto = new CustomerDTO();
		customerDto.setAddress(addressEntity.getAddress());
		customerDto.setCountry(addressEntity.getCountry());
		customerDto.setZipCode(addressEntity.getZipCode());
		customerDto.setFullName(customerEntity.getFirstName().concat(" ").concat(customerEntity.getLastName()));
		customerDto.setId(customerEntity.getId());
		customerDto.setEmail(customerEntity.getEmail());
		customerDto.setNumeroMuertes(partidaEntity.getNumeroMuertes());
		customerDto.setEnemigosFantasmaDerrotados(partidaEntity.getEnemigosFantasmaDerrotados());
		customerDto.setEnemigosEsqueletosDerrotados(partidaEntity.getEnemigosEsqueletosDerrotados());
		customerDto.setEnemigosBestiaDerrotados(partidaEntity.getEnemigosBestiaDerrotados());
		customerDto.setBossFinalDerrotados(partidaEntity.getBossFinalDerrotados());
		customerDto.setMonedasObtenidas(partidaEntity.getMonedasObtenidas());
		customerDto.setNivelSecreto(partidaEntity.getNivelSecreto());
		
		return new ResponseEntity<CustomerDTO>(customerDto, HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthDtoResponse> loginCustomer(@RequestBody @Valid AuthDto authRequest){				
		AuthDtoResponse authDtoResponse = new AuthDtoResponse();
		 			
		CustomerEntity customerEntity = customerProvider.findByEmail(authRequest.getEmail());
								
		if(customerEntity!=null && customerEntity.getPassword().equals(authRequest.getPassword())) {
			authDtoResponse.setEmail(customerEntity.getEmail());
			authDtoResponse.setFullName(customerEntity.getFirstName().concat(" ").concat(customerEntity.getLastName()));
			authDtoResponse.setValidado(true);
		}else {
			authDtoResponse.setEmail(authRequest.getEmail());			
			authDtoResponse.setValidado(false);
		}
					
		return new ResponseEntity<AuthDtoResponse>(authDtoResponse, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<AuthDtoResponse> saveCustomer(@RequestBody @Valid RegisterDto registerRequest){
		AuthDtoResponse authDtoResponse = new AuthDtoResponse();
		
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setFirstName(registerRequest.getName());
		customerEntity.setLastName(registerRequest.getLastName());
		customerEntity.setEmail(registerRequest.getEmail());
		customerEntity.setPassword(registerRequest.getPassword());
		
		customerRepository.save(customerEntity);
		CustomerEntity customerEntityA =customerProvider.findByEmail(customerEntity.getEmail());
		
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setCustomer(customerEntityA);
		addressEntity.setCountry(registerRequest.getCountry());
		addressEntity.setAddress(registerRequest.getAddress());
		addressEntity.setZipCode(registerRequest.getZipCode());		
		
		addressRepository.save(addressEntity);
				
		return new ResponseEntity<AuthDtoResponse>(authDtoResponse, HttpStatus.OK);
	}
}
