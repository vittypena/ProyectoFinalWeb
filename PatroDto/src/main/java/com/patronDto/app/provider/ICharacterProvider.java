package com.patronDto.app.provider;

import java.util.Optional;

import com.patronDto.app.entity.CharacterEntity;

public interface ICharacterProvider {
	Optional<CharacterEntity> findById(Long id);
}
