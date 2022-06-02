import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { PersonajesComponent } from './personajes/personajes.component';
import { ErrorPageComponent } from './shared/error-page/error-page.component';
import { InformacionComponent } from './heroe/informacion/informacion.component';
import { EstadisticasUsuarioComponent } from './heroe/estadisticas-usuario/estadisticas-usuario.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    ErrorPageComponent,
    HeaderComponent,
    EstadisticasUsuarioComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
