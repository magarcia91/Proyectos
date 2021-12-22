import { Injectable } from '@angular/core';
import { Parjub } from '../model/parjub';

@Injectable({
  providedIn: 'root'
})
export class LocalStorageJubilacionesService {

  parJubilaciones: Parjub

  constructor() { }

  get jubilacionesData(){
    return this.parJubilaciones;
  }

  set jubilacionesData(parJubilaciones: Parjub){    
    this.parJubilaciones=parJubilaciones;
  }
}

