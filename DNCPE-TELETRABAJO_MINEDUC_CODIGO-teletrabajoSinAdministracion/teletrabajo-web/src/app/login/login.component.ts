import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'app/services/AuthService';
import { environment } from 'environments/environment';
import Swal from 'sweetalert2';
import { Captcha } from 'app/entity/Captcha';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public token: any;
  public usuario: string;
  public pass: string;
  public urlCaptcha: any;
  public textoImagenCaptcha: string;
  public valorCaptcha: Captcha;


  constructor(private router: Router, private authService: AuthService) {}
  ngOnInit() {   
    this.authService.getValorCaptcha().subscribe((data:Captcha)=>{               
      this.valorCaptcha= data;  
      this.urlCaptcha = environment.url_back_end +'/public/login/imagenCaptcha?code='+this.valorCaptcha.valorGenerado;       
   });         
    this.token = localStorage.getItem('token');    
    if (this.token != null) {
      this.router.navigate(['dashboard']);
    }
  }

 public onSubmit() {
    if(this.textoImagenCaptcha == undefined || this.textoImagenCaptcha.length == 0){
      Swal.fire('Atención', 'El texto de la imagen es obligatorio. Por favor verifique.', 'warning');
    }else{     
      if(this.valorCaptcha == undefined || this.valorCaptcha == null){
        Swal.fire('Atención', 'Ha ocurrido un error al generar el captcha. Por favor comuníquese con el administrador del sistema.', 'warning');
      }else{        
        this.valorCaptcha.valorIngresado = this.textoImagenCaptcha;           
          // post the captcha data to the backend
        this.authService.send(this.valorCaptcha)
        .subscribe(
          response => {
            if (response.success == false) {
              Swal.fire('Atención', 'Captcha incorrecto. Por favor verifique.', 'warning');          
            } else {
              this.authService.login(this.usuario, this.pass);
          }
          });
      }       
  }
}

  refresh(): void {
    window.location.reload();
  }
}
