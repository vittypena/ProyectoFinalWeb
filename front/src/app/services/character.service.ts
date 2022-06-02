
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Character } from '../interfaces/character-model';

@Injectable({
  providedIn: 'root'
})
export class CharacterService {
  private readonly urlApi: string;

  constructor(
    private http: HttpClient
  ) {
    this.urlApi = "http://localhost:8080/api";
  }

  getCharacterById( id: string ):Observable<Character> {
    return this.http.get<Character>(`${ this.urlApi }/character/${ id }`);
  }

}