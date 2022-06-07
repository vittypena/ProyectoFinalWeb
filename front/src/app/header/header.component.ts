import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { User } from '../interfaces/user-model';
import { AuthService } from '../services/authService';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styles: [
  ]
})
export class HeaderComponent implements OnInit{  
  usuario: User ={
    email:"",
    fullName:"",
    validado: false
};


  constructor(
    private _authService: AuthService
  ) { }

  ngOnInit(): void {    
  }
  
}
