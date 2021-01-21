import { ReceiverComponent } from './receiver/receiver.component';
import { ReceiverCadastroComponent } from './receiver/receiver-cadastro/receiver-cadastro.component';
import { ReceiverConsultaComponent } from './receiver/receiver-consulta/receiver-consulta.component';
import {Routes} from '@angular/router'


export const ROUTES: Routes = [
   {
      path: 'gerenciar',
      component:  ReceiverComponent,
      children: [
        {path: '', redirectTo: 'geral', pathMatch: 'full',data: {animation: 'primeira'}},
        {path: 'consulta', component: ReceiverConsultaComponent, data: {animation: 'primeira'}},
        {path: 'cadastro', component: ReceiverCadastroComponent, data: {animation: 'ultima'}}
      ]
    },
]
