import { ReceiverComponent } from './receiver/receiver.component';
import { ReceiverCadastroComponent } from './receiver/receiver-cadastro/receiver-cadastro.component';
import { ReceiverConsultaComponent } from './receiver/receiver-consulta/receiver-consulta.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { RouterModule } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ROUTES } from './app.routes';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ReceiverConsultaComponent,
    ReceiverCadastroComponent,
    ReceiverComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(ROUTES),
    BrowserAnimationsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
