import { slideInAnimation } from './route.animation';
import { Component } from '@angular/core';

@Component({
  selector: 'track-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  animations: [ slideInAnimation ]
})
export class AppComponent {
  title = 'frontEndAgunlar';
}
