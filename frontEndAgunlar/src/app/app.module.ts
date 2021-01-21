import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { DonatorComponent } from './donator/donator.component';
import { RouterModule } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ROUTES } from './app.routes';
import { DonatorConsultaComponent } from './donator/donator-consulta/donator-consulta.component';
import { DonatorCadastroComponent } from './donator/donator-cadastro/donator-cadastro.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    DonatorComponent,
    DonatorConsultaComponent,
    DonatorCadastroComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(ROUTES),
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
