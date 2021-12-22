import { Injectable } from '@angular/core';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class MensajesService {

  constructor() { }

  mensajeError(titulo: string, mensaje: string): void{
    Swal.fire({
      title: titulo,
      text: mensaje,
      icon: 'error'
    });
  }

  mensajeCorrecto(titulo: string, mensaje: string): void{
    Swal.fire({
      title: titulo,
      text: mensaje,
      icon: 'success'
    });
  }
  mensajeAdvertencia(titulo: string, mensaje: string): void{
    Swal.fire({
      title: titulo,
      text: mensaje,
      icon: 'warning'
    });
  }
}
