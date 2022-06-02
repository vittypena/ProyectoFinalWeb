package com.patronDto.app.providerImlp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patronDto.app.dao.ICharacterRepository;
import com.patronDto.app.entity.CharacterEntity;
import com.patronDto.app.provider.ICharacterProvider;

@Service
public class CharacterProviderImpl implements ICharacterProvider{

	@Autowired
	ICharacterRepository characterRepository;
	
	@Override
	public Optional<CharacterEntity> findById(Long id) {		
		return characterRepository.findById(id);
	}

}
