
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Character } from '../interfaces/character-model';
import { Customer } from '../interfaces/customer-model';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private readonly urlApi: string;

  constructor(
    private http: HttpClient
  ) {
    this.urlApi = "http://localhost:8080/api";
  }

  getCustomerByEmail( bodyparams: Customer ):Observable<Customer> {
    return this.http.post<Customer>(`${ this.urlApi }/customers`, bodyparams);
  }

}
