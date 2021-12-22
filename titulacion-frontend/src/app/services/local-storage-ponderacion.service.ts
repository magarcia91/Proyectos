import { Injectable } from '@angular/core';
import { Ponderacion } from '../core/model/ponderacion';

@Injectable({
  providedIn: 'root'
})
export class LocalStoragePonderacionService {

  ponderacion: Ponderacion;

  constructor() {}

  get ponderacionData(){
    return this.ponderacion;
  }

  set ponderacionData(ponderacion: Ponderacion){    
    this.ponderacion=ponderacion;
  }
}
