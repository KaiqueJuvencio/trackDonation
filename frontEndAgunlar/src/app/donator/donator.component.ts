import { slideInAnimation } from './../route.animation';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'track-donator',
  templateUrl: './donator.component.html',
  styleUrls: ['./donator.component.css'],
  animations: [ slideInAnimation ]
})
export class DonatorComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
