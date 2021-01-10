import {Routes} from '@angular/router'
import { DonatorComponent } from './donator/donator.component'
import { ReceiverComponent } from './receiver/receiver.component'

export const ROUTES: Routes = [
   {path: 'donator', component: DonatorComponent},
   {path: 'receiver', component: ReceiverComponent}
]