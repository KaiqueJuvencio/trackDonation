import { ReceiverService } from './../../services/receiver.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'track-donator-consulta',
  templateUrl: './receiver-consulta.component.html',
  styleUrls: ['./receiver-consulta.component.css']
})
export class ReceiverConsultaComponent implements OnInit {

  constructor(private receiverService: ReceiverService) { }

  ngOnInit() {
    this.receiverService.findAllReceivers()
      .subscribe(receivers =>{
        console.log(receivers);
    })
  }
}
