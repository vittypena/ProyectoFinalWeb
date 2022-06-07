package com.patronDto.app.providerImlp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patronDto.app.dao.IAddressRepository;
import com.patronDto.app.dao.ICustomerRepository;
import com.patronDto.app.dao.IPartidaRepository;
import com.patronDto.app.entity.AddressEntity;
import com.patronDto.app.entity.CustomerEntity;
import com.patronDto.app.entity.PartidaEntity;
import com.patronDto.app.provider.ICustomerProvider;

@Service
public class CustomerProviderImpl implements ICustomerProvider {

	@Autowired
	private ICustomerRepository customerRepository;
	
	@Autowired
	private IAddressRepository addressRepository;
	
	@Autowired IPartidaRepository partidaRepository;

	@Override
	public Optional<CustomerEntity> findById(Long id) {
		return customerRepository.findById(id);
	}

	@Override
	public AddressEntity findAddressByCostumer(CustomerEntity customerEntity) {
		return addressRepository.findByCustomer(customerEntity);
	}		
	
	@Override
	public PartidaEntity findPartidaByCostumer(CustomerEntity customerEntity) {
		return partidaRepository.findByCustomer(customerEntity);
	}

	@Override
	public CustomerEntity findByEmail(String email) {		
		return customerRepository.findByEmail(email);
	}		
}
