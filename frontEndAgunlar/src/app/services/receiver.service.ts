import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable({
  providedIn: 'root'
})

export class ReceiverService{
  constructor(private http : HttpClient){ }

  findAllReceivers(){
    return this.http.get(`https://api.github.com/users/KaiqueJuvencio/repos`)
  }
}
