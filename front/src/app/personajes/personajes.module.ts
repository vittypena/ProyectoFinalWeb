import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PersonajesComponent } from './personajes.component';
import { PersonajesRoutingModule } from './personajes-routing.module';
import { InformacionComponent } from '../heroe/informacion/informacion.component';



@NgModule({
  declarations: [
    PersonajesComponent,
    InformacionComponent
  ],
  imports: [
    CommonModule,
    PersonajesRoutingModule
  ]
})
export class PersonajesModule { }
