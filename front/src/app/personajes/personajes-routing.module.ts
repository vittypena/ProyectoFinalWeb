import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PersonajesComponent } from './personajes.component';
import { InformacionComponent } from '../heroe/informacion/informacion.component';
import { EstadisticasUsuarioComponent } from '../heroe/estadisticas-usuario/estadisticas-usuario.component';

const routes: Routes = [
  {
    path: '',
    component: InformacionComponent,
    children: [
      { path: 'informacion/:id', component: PersonajesComponent },
      { path: '**', redirectTo: 'personajes' }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PersonajesRoutingModule { }
