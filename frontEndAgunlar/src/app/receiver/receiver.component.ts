import { slideInAnimation } from '../route.animation';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'track-donator',
  templateUrl: './receiver.component.html',
  styleUrls: ['./receiver.component.css'],
  animations: [ slideInAnimation ]
})
export class ReceiverComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
