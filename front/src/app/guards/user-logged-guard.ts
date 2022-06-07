import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';
import {Observable} from 'rxjs';
import { AuthService } from '../services/authService';

@Injectable({
  providedIn: 'root',
  deps: [AuthService, Router]
})
export class UserLoggedGuard implements CanActivate {
  constructor(
    private readonly authService: AuthService,
    private readonly router: Router
  ) {}

  canActivate(
      next: ActivatedRouteSnapshot,
      state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {     
    if (sessionStorage.getItem('validado') === 'Y' || this.authService._usuarioActual.validado === true) {             
      return true;
    }
    this.router.navigate([`/auth/login`]);
    return false;  
  }
}