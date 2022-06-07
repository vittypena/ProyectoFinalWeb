import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ErrorPageComponent } from './shared/error-page/error-page.component';
import { EstadisticasUsuarioComponent } from './heroe/estadisticas-usuario/estadisticas-usuario.component';
import { UserLoggedGuard } from './guards/user-logged-guard';

const routes: Routes = [  
  {
    path: '',
    redirectTo: 'auth',
    pathMatch: 'full'
  },
  {
    path: 'auth',
    loadChildren: () => import('./auth/auth.module').then( m => m.AuthModule )
  },
  {
    path: 'personajes',
    loadChildren: () => import('./personajes/personajes.module').then( m => m.PersonajesModule ),
    canActivate: [UserLoggedGuard]
  },
  {
    path: 'estadisticas',
    component: EstadisticasUsuarioComponent,
    canActivate: [UserLoggedGuard]
  },
  {
    path: '404',
    component: ErrorPageComponent
  },
  {
    path: '**',
    // component: ErrorPageComponent
    redirectTo: '404'
  }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
