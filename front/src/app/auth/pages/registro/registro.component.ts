import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AuthService } from 'src/app/services/authService';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styles: [
  ]
})
export class RegistroComponent implements OnInit {

  miFormulario: FormGroup = this.fb.group({
    email: ['', ],
    password: ['',],
    name: ['',],
    lastName: ['', ],
    address: ['', ],
    country: ['', ],
    zipCode: ['', ]
  });

  constructor(
    private fb: FormBuilder,
    private _authService: AuthService
  ) { }

  ngOnInit(): void {
  }

  registrar(){
    this._authService.registrar(JSON.stringify(this.miFormulario.value));   
  }    
}
