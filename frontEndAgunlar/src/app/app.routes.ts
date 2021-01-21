import {Routes} from '@angular/router'
import { DonatorCadastroComponent } from './donator/donator-cadastro/donator-cadastro.component'
import { DonatorConsultaComponent } from './donator/donator-consulta/donator-consulta.component'
import { DonatorComponent } from './donator/donator.component'
import { ReceiverComponent } from './receiver/receiver.component'

export const ROUTES: Routes = [
  {path: '', component: DonatorComponent, data: {animation: 'Home'}},
   {path: 'donator', component: DonatorComponent, data: {animation: 'Home'}},
   {path: 'receiver', component: ReceiverComponent, data: {animation: 'About'}},
   {
      path: 'donator',
      component: DonatorComponent,
      children: [
        {path: '', redirectTo: 'geral', pathMatch: 'full'},
        {path: 'consulta', component: DonatorConsultaComponent, data: {animation: 'Home'}},
        {path: 'cadastro', component: DonatorCadastroComponent, data: {animation: 'About'}}
      ]
    },
]
