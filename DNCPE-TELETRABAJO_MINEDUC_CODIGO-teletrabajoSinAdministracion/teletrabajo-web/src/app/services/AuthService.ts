import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { environment } from 'environments/environment';
import { Observable } from 'rxjs';
import { Captcha } from 'app/entity/Captcha';


@Injectable()
export class AuthService {

    result: any;
    constructor(public router: Router, private httpClient: HttpClient) { }

    async  login(cedula: string, password: string) {

        try {

            // call login service

            return this.httpClient.get(environment.url_back_end + '/public/login?identificacion='+cedula+'&password='+password).subscribe((res: any) => {
                if(res.codigoError === 0) {
                    localStorage.setItem('token', res.token);
                    localStorage.setItem('nombre', res.nombre);
                    localStorage.setItem('roles', res.role);
                    localStorage.setItem('identificacion', res.identificacion);
                    localStorage.setItem('zona', res.zona);
                    localStorage.setItem('distrito', res.distrito);
                    localStorage.setItem('cambioObligatorioClave', res.cambioObligatorioClave);                    
                    localStorage.setItem('psCode', res.passCode);
                    localStorage.setItem('habilitadaEncuesta', res.habilitadaEncuesta);                    
                    location.reload();
                } else {
                    Swal.fire({
                        title: 'Atención',
                        html: '<center>'+res.mensaje+'</center>',
                        icon: 'warning',
                        width: '70%',
                        showCancelButton: false,
                      }).then((result) => {
                      });
                    //Swal.fire('Atención',res.mensaje,'warning');
                }
            });

            
        } catch (e) {
            Swal.fire('Atención', 'Usuario y/o contraseña incorrecto', 'warning');
        }
    }

    async logout() {
        localStorage.clear();                
        this.router.navigate(['login']);                     
        let timerInterval;
        Swal.fire({
        title: '¡Cerrando la sesión!',
        timer: 500,
        timerProgressBar: true,
        allowOutsideClick: false,
        backdrop: `
            rgba(0,0,0,0.9)
            left top
            no-repeat
        `,
        onBeforeOpen: () => {
            Swal.showLoading();
        },
        onClose: () => {
            clearInterval(timerInterval)
        }
        }).then((result) => {
        /* Read more about handling dismissals below */
        if (result.dismiss === Swal.DismissReason.timer) {            
            location.reload(); 
        }
        })         
    }

    isLoggedIn(): boolean {
        const user = localStorage.getItem('token');
        return user !== null;
    }

    getRoles(): any {
        const roles = localStorage.getItem('roles');
        return roles;
    }

    validateLogin(recurso: any) {                
        const user = localStorage.getItem('token');               
        if (user !== null) {
            var cambiarClave = localStorage.getItem('cambioObligatorioClave');            
            if(cambiarClave == 'true'){
                this.router.navigate(['clave']);
            }else{
                this.router.navigate([recurso]);
            }                       
        } else {            
            Swal.fire({
                title: '¡La sesión de la aplicación ha caducado!',
                text: "Por favor inicie nuevamente una sesión.",
                icon: 'warning',                
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Ok'
            }).then((result) => {
                if (result.value) {
                    this.router.navigate(['login']);
                }
            });
                                                                     
        }                    
    }

    send(data: Captcha): Observable<any> {       
        return this.httpClient.post(environment.url_back_end+'/public/login/validarCaptcha', data);
      }
    
    getValorCaptcha(){
        return this.httpClient.get(environment.url_back_end + '/public/login/valorCaptcha');    
    }

    sendSolicitudReseteoClave(data: any){
        return this.httpClient.post(environment.url_back_end + '/public/login/enviarSolicitud',data); 
    }
    sendSolicitudReseteoCorreo(data: any){
        return this.httpClient.post(environment.url_back_end + '/public/login/enviarSolicitudRecuperarCorreo',data); 
    }
    
    lanzarDialogoExpirarSesion(){
        Swal.fire({
            title: 'Atención',
            text: '¡Su sesión ha expirado!',
            icon: 'error',
            confirmButtonColor: '#3085d6',            
            confirmButtonText: 'Ok',
            allowOutsideClick: false,
          }).then((result) => {
              if(result.value){
                localStorage.clear();
                location.reload();
              }            
          });
    }
}
