import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/authService';
import { User } from '../../../interfaces/user-model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styles: [
  ]
})
export class LoginComponent implements OnInit {


  constructor(
    private fb: FormBuilder,
    private _authService: AuthService,
    private readonly _routerService: Router
  ) { }

  miFormulario: FormGroup = this.fb.group({
    email: ['', ],
    password: ['',]
  });

  ngOnInit(): void {
    if(sessionStorage.getItem('validado')){
      this._authService.actualizarUsuario();
      console.log("Se va pa personajes");
      this.goToPersonajes();      
    }
  }

  login(){
    this._authService.login(JSON.stringify(this.miFormulario.value));    
    this.goToPersonajes();
  }    

  goToPersonajes(){
    this._routerService.navigate([`/personajes`]);
  }
}  