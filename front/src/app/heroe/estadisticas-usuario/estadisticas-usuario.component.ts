import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from 'src/app/interfaces/customer-model';
import { AuthService } from 'src/app/services/authService';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-estadisticas-usuario',
  templateUrl: './estadisticas-usuario.component.html',
  styles: [
  ]
})
export class EstadisticasUsuarioComponent implements OnInit {

  public customer: Customer ={
    id: 0,
    country: '',
    address: '',
    zipCode: '',
    email: '',
    numeroMuertes: 0,
    enemigosFantasmaDerrotados: 0,
    enemigosEsqueletosDerrotados: 0,
    enemigosBestiaDerrotados: 0,
    bossFinalDerrotados: 0,
    monedasObtenidas: 0,
    nivelSecreto: false,
    fullName: ''
  };

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private _authService: AuthService,
    private _customerService: CustomerService
  ) {   
  }

  ngOnInit(): void {
    this._authService.actualizarUsuario();
    this.customer.email= this._authService.usuarioActual.email;
    // this.customer.email = "vitty@hotmail.com";
    this._customerService.getCustomerByEmail( this.customer )
    .subscribe( usuario => this.customer = usuario );
  }

}
