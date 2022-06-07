package com.patronDto.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.patronDto.app.entity.CustomerEntity;

public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long>{	
	CustomerEntity findByEmail(String email);
}
