import {Routes} from '@angular/router'
import { DonatorCadastroComponent } from './donator/donator-cadastro/donator-cadastro.component'
import { DonatorConsultaComponent } from './donator/donator-consulta/donator-consulta.component'
import { DonatorComponent } from './donator/donator.component'
import { ReceiverComponent } from './receiver/receiver.component'

export const ROUTES: Routes = [
   {path: 'donator', component: DonatorComponent},
   {path: 'receiver', component: ReceiverComponent},
   {
      path: 'donator',
      component: DonatorComponent,
      children: [
        {path: '', redirectTo: 'geral', pathMatch: 'full'},
        {path: 'consulta', component: DonatorConsultaComponent},
        {path: 'cadastro', component: DonatorCadastroComponent}
      ]
    },
]