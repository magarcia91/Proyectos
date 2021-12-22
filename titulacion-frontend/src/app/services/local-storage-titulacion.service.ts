import { Injectable } from '@angular/core';
import { FechasTitulacion } from '../core/model/fechas-titulacion';

@Injectable({
  providedIn: 'root'
})
export class LocalStorageTitulacionService {

  fechasTitulacion:FechasTitulacion;

  constructor() { }

  get fechasTitulacionData(){
    return this.fechasTitulacion;
  }

  set fechasTitulacionData(fechasTitulacion: FechasTitulacion){    
    this.fechasTitulacion=fechasTitulacion;
  }
}
