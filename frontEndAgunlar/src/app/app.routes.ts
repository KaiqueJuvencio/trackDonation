import {Routes} from '@angular/router'
import { DonatorCadastroComponent } from './donator/donator-cadastro/donator-cadastro.component'
import { DonatorConsultaComponent } from './donator/donator-consulta/donator-consulta.component'
import { DonatorComponent } from './donator/donator.component'
import { ReceiverComponent } from './receiver/receiver.component'

export const ROUTES: Routes = [
  // {path: '', component: DonatorComponent},
   {path: 'donator', component: DonatorComponent},
   {path: 'receiver', component: ReceiverComponent},
   {
      path: 'gerenciar',
      component: DonatorComponent,
      children: [
        {path: '', redirectTo: 'geral', pathMatch: 'full',data: {animation: 'primeira'}},
        {path: 'consulta', component: DonatorConsultaComponent, data: {animation: 'primeira'}},
        {path: 'cadastro', component: DonatorCadastroComponent, data: {animation: 'ultima'}}
      ]
    },
]
