import { Component, OnInit } from '@angular/core';
import { AuthService } from 'app/services/AuthService';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-recuperar-clave',
  templateUrl: './recuperar-clave.component.html',
  styleUrls: ['./recuperar-clave.component.css']
})
export class RecuperarClaveComponent implements OnInit {

  public identificacion: string;
  public anio: any;
  public correo: string;
  public mensajeValidacion: string;
  public opcionPeticionSeleccionada: number;
  public opcionesPeticion: any[] = new Array();
  
  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit() {
    this.opcionesPeticion.push({id: 1, text: 'Correo electrónico personal'});
    this.opcionesPeticion.push({id: 2, text: 'Correo electrónico institucional'});
  }

  validarSolicitud(){
    this.mensajeValidacion='';
    var guardar = true;       
    if(this.identificacion==null || this.identificacion==''){
      guardar = false;
      this.mensajeValidacion='El campo identificación es obligatorio. Por favor verifique.';
    }else if(this.correo==null || this.correo==''){
      guardar = false;
      this.mensajeValidacion='El campo correo electrónico es obligatorio. Por favor verifique.';
    }else if(this.anio==null || this.anio==''){
      guardar = false;
      this.mensajeValidacion='El campo año de nacimiento es obligatorio. Por favor verifique.';
    }else if(this.opcionPeticionSeleccionada==null || this.opcionPeticionSeleccionada==0){
      guardar = false;
      this.mensajeValidacion='El campo tipo de correo electrónico para la petición es obligatorio. Por favor verifique.';
    }
    return guardar;
  }

  enviarSolicitud(){
    if(this.validarSolicitud()){
      var solicitud ={
        identificacion: this.identificacion,
        correoElectronico: this.correo,
        anioNacimiento: this.anio,
        peticionConCorreoPersonal: this.opcionPeticionSeleccionada == 1
      };
     
      this.authService.sendSolicitudReseteoClave(solicitud)
          .subscribe(
            (res: any) => {
              if(res.codigoError === 0) {                                   
                Swal.fire({
                  title: 'La solicitud de recuperación de contraseña fue exitoso.',
                  text: res.mensaje,
                  icon: 'success',                
                  confirmButtonColor: '#3085d6',
                  cancelButtonColor: '#d33',
                  confirmButtonText: 'Aceptar',
                  allowOutsideClick: false
                }).then((result) => {
                    if (result.value) {
                      this.router.navigate(['login']);
                    }
                });                 
              } else {
                Swal.fire('Atención',res.mensaje,'error');
              }
          });
    }else{
      Swal.fire('Atención',this.mensajeValidacion,'warning');
    }    
    
  }

}
