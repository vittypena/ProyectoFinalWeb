
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Character } from '../interfaces/character-model';
import { User } from '../interfaces/user-model';
import { UserRequest } from '../interfaces/userRequest-model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  _usuarioActual: User ={
      email:"",
      fullName:"",
      validado: false
  };

  public get usuarioActual(): User{
    return this._usuarioActual;
  }

  private readonly urlApi: string;

  constructor(
    private http: HttpClient
  ) {
    this.urlApi = "http://localhost:8080/api";
  }


  login(bodyParams: any){
    this.http.post<User>(`${ this.urlApi }/login`, bodyParams, {
        headers: new HttpHeaders()
        .set('content-type','application/json')
    }).subscribe((data: User) => {
        // console.log("Datos desde el back, data: " + data.email + " " + data.fullName + " " + data.validado);
        this._usuarioActual = data;
        // console.log("Desde el servicio: " + this._usuarioActual.email + " " + this._usuarioActual.fullName + " " +this._usuarioActual.validado);
        this.guardarSessionStorage(this._usuarioActual);
      });      
  }

  registrar(bodyParams: any){
    this.http.post<User>(`${ this.urlApi }/save`, bodyParams, {
        headers: new HttpHeaders()
        .set('content-type','application/json')
    }).subscribe((data: User) => {
        console.log(data);
      });      
  }

  guardarSessionStorage(datos: User){
    sessionStorage.setItem('email', datos.email);
    sessionStorage.setItem('fullName', datos.fullName);
    sessionStorage.setItem('validado', datos.validado===true?"Y":"N");
  }
  
  actualizarUsuario(){
    if(sessionStorage.getItem('validado')==="Y"){
      var email = sessionStorage.getItem('email')+"";
      this._usuarioActual.email = email;
      var fullName = sessionStorage.getItem('fullName')+"";
      this._usuarioActual.fullName = fullName;     
      this._usuarioActual.validado = true;    
    }
  }
}