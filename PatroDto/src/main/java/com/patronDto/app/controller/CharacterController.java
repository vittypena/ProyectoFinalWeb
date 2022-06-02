package com.patronDto.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patronDto.app.dto.CharacterDto;
import com.patronDto.app.entity.CharacterEntity;
import com.patronDto.app.provider.ICharacterProvider;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api")
public class CharacterController {

	@Autowired
	ICharacterProvider characterProvider;
	
	@GetMapping("/character/{idCharacter}")
	public ResponseEntity<?> showCustomerDTO(@PathVariable Long idCharacter){
		
		Optional<CharacterEntity> characterEntity = characterProvider.findById(idCharacter);
		
		//Rellenamos el customerDto que retornaremos
		CharacterDto characterDto = new CharacterDto();
		characterDto.setId(characterEntity.get().getId());
		characterDto.setDescripcion(characterEntity.get().getDescripcion());
		characterDto.setFrase(characterEntity.get().getFrase());
		characterDto.setNombre(characterEntity.get().getNombre());
		characterDto.setRutaImagen(characterEntity.get().getRutaImagen());
		
		return new ResponseEntity<CharacterDto>(characterDto, HttpStatus.OK);
	}
	
}
