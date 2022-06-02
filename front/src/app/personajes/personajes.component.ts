import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { switchMap } from 'rxjs';
import { Character } from '../interfaces/character-model';
import { CharacterService } from '../services/character.service';

@Component({
  selector: 'app-personajes',
  templateUrl: './personajes.component.html',
  styles: [
  ]
})
export class PersonajesComponent implements OnInit {

  public character?: Character;

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private _characterService: CharacterService
    ) {      
    }

  ngOnInit(): void {
    this.activatedRoute.params
      .pipe(
        switchMap( ({ id }) => this._characterService.getCharacterById(id) )
      )
      .subscribe( heroe => this.character = heroe );
    console.log(this.character)
  }

}
