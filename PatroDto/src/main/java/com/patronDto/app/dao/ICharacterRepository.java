package com.patronDto.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patronDto.app.entity.CharacterEntity;

public interface ICharacterRepository extends JpaRepository<CharacterEntity, Long>{	
}