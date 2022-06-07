package com.patronDto.app.provider;

import java.util.List;
import java.util.Optional;

import com.patronDto.app.entity.AddressEntity;
import com.patronDto.app.entity.CustomerEntity;
import com.patronDto.app.entity.PartidaEntity;

public interface ICustomerProvider {
	Optional<CustomerEntity> findById(Long id);
	AddressEntity findAddressByCostumer(CustomerEntity customerEntity);
	PartidaEntity findPartidaByCostumer(CustomerEntity customerEntity);
	CustomerEntity findByEmail(String email);
}
