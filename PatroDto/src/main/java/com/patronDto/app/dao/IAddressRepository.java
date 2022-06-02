package com.patronDto.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patronDto.app.entity.AddressEntity;
import com.patronDto.app.entity.CustomerEntity;

public interface IAddressRepository extends JpaRepository<AddressEntity, Long>{
	AddressEntity findByCustomer(CustomerEntity customerEntity);
}
