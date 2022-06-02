package com.patronDto.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patronDto.app.entity.CustomerEntity;
import com.patronDto.app.entity.PartidaEntity;

public interface IPartidaRepository extends JpaRepository<PartidaEntity, Long>{	
	PartidaEntity findByCustomer(CustomerEntity customerEntity);
}
