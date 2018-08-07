import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

@Injectable()
export class BirdsService {

  url = '';
  result;

  getBirds(){
      return this.http.get('http://localhost:8080/tont-back/services/birds/list')
      .subscribe(result => result.json());//.suscribe(response => response);
  }

  saveBird(bird, update){
      if (!update){
          this.url = 'http://localhost:8080/tont-back/services/birds/create';
      }else{
          this.url = 'http://localhost:8080/tont-back/services/birds/update';
      }
      return this.http.post(this.url, bird)
      .subscribe(result => result.json());//.suscribe(response => response);
  }

  constructor(private http:Http) { }

}
