import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { DonatorComponent } from './donator/donator.component';
import { RouterModule } from '@angular/router';
import { ROUTES } from './app.routes';
import { ReceiverComponent } from './receiver/receiver.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    DonatorComponent,
    ReceiverComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(ROUTES)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
