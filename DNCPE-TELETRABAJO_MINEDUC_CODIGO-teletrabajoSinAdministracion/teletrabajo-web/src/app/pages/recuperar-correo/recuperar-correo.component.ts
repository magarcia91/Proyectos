import { Component, OnInit } from '@angular/core';
import { AuthService } from 'app/services/AuthService';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Captcha } from 'app/entity/Captcha';
import { environment } from 'environments/environment';

@Component({
  selector: 'app-recuperar-correo',
  templateUrl: './recuperar-correo.component.html',
  styleUrls: ['./recuperar-correo.component.css']
})
export class RecuperarCorreoComponent implements OnInit {

  public identificacion: string;
  public anio: number;
  public correo: string;
  public mensajeValidacion: string;
  public anioExpedicion: number;
  public urlCaptcha: any;
  public textoImagenCaptcha: string;
  public valorCaptcha: Captcha;
  
  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit() {
    this.authService.getValorCaptcha().subscribe((data:Captcha)=>{               
      this.valorCaptcha= data;  
      this.urlCaptcha = environment.url_back_end +'/public/login/imagenCaptcha?code='+this.valorCaptcha.valorGenerado;       
   });
  }

  refresh(): void {
    window.location.reload();
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
    }else if(this.anio==null || this.anio==0){
      guardar = false;
      this.mensajeValidacion='El campo año de nacimiento es obligatorio. Por favor verifique.';
    }else if(this.anioExpedicion==null || this.anioExpedicion==0){
      guardar = false;
      this.mensajeValidacion='El campo año de expedición de la cédula de identidad es obligatorio. Por favor verifique.';
    }else if(this.textoImagenCaptcha == undefined || this.textoImagenCaptcha.length == 0){
      guardar = false;
      this.mensajeValidacion='El texto de la imagen es obligatorio. Por favor verifique.';
    }else if(this.valorCaptcha == undefined || this.valorCaptcha == null){
      guardar = false;
      this.mensajeValidacion='Ha ocurrido un error al generar el captcha. Por favor comuníquese con el administrador del sistema.';
    }
    return guardar;
  }

  enviarCaptchaYSolicitud() {
    if(this.validarSolicitud()){      
        this.valorCaptcha.valorIngresado = this.textoImagenCaptcha;                     
        this.authService.send(this.valorCaptcha)
        .subscribe(
          response => {
            if (response.success == false) {
              Swal.fire('Atención', 'Captcha incorrecto. Por favor verifique.', 'warning');          
            } else {
              this.enviarSolicitud();
            }
          });
      }else{
        Swal.fire('Atención',this.mensajeValidacion,'warning');
      }        
  }

  enviarSolicitud(){    
      var solicitud ={
        identificacion: this.identificacion,
        correoElectronico: this.correo,
        anioNacimiento: this.anio,
        anioExpedicionCedula: this.anioExpedicion,
      };
      
      this.authService.sendSolicitudReseteoCorreo(solicitud)
          .subscribe(
            (res: any) => {
              if(res.codigoError === 0) {                                   
                Swal.fire({
                  title: 'La solicitud de recuperación del correo electrónico fue exitoso.',
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
  }

}
