import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { AuthService } from 'app/services/AuthService';
import Swal from 'sweetalert2';
import { UsuarioService } from 'app/services/usuario.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-clave',
  templateUrl: './clave.component.html',
  styleUrls: ['./clave.component.scss']
})
export class ClaveComponent implements OnInit {

  formularioClave: FormGroup;
  mensajeValidacion: string;
  mensajes_validacion_formulario = {
    'clave': [
      { type: 'required', message: 'Una contraseña es requerida.' },      
      { type: 'maxlength', message: 'La contraseña no puede ser mayor a 15 caracteres.' },
      { type: 'minlength', message: 'La contraseña no puede ser menor a 8 caracteres.' },
      { type: 'pattern', message: 'Contraseña no válida.' }
    ],
    'confirmarClave': [
      { type: 'required', message: 'La confirmación de contraseña es requerida.' },      
      { type: 'maxlength', message: 'La confirmación de contraseña no puede ser mayor a 15 caracteres.' },
      { type: 'minlength', message: 'La confirmación de contraseña no puede ser menor a 8 caracteres.' },      
    ],
    }

  constructor(private formBuilder: FormBuilder, private authService: AuthService, private usuarioService:UsuarioService, public router: Router) { 
    this.formularioClave = this.formBuilder.group({
      clave: new FormControl('', Validators.compose([
        Validators.required,        
        Validators.pattern('^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[!@$^*./_-]).{8,}$'),
        Validators.maxLength(15),
        Validators.minLength(8)
      ])),
      confirmarClave: new FormControl('', Validators.compose([
        Validators.required,                
        Validators.maxLength(15),
        Validators.minLength(8)
      ]))
    });
  }

  ngOnInit() {
    if (localStorage.getItem('token') === null) {
      localStorage.clear();
    }
    this.authService.validateLogin('clave');
    if (this.authService.isLoggedIn()) {      
      var cambioObligatorio = localStorage.getItem('cambioObligatorioClave');
      if(cambioObligatorio == 'false'){        
        this.router.navigate(['dashboard']);
      }
    }
  }

  validarConfirmacion(){
    this.mensajeValidacion='';
    var guardar = true;       
    if(this.formularioClave.get('clave').value != this.formularioClave.get('confirmarClave').value){
      guardar = false;
      this.mensajeValidacion='La contraseña y su confirmación no coinciden. Por favor verifique.';
    }
    return guardar;
  }

  crearClave(formulario){     
    if(formulario.valid){
      if(this.validarConfirmacion()){
        var claveUsuario = {
          codClaveUsuario: localStorage.getItem('psCode'),
          clave: this.formularioClave.get('clave').value          
        };
        this.usuarioService.guardarClaveUsuario(claveUsuario).subscribe((res: any) => { 
          if(res.codigoError === 0) {                                  
            Swal.fire({
              title: '¡Contraseña guardada correctamente!',
              text: "Inicie nuevamente una sesión con la contraseña registrada.",
              icon: 'success',                
              confirmButtonColor: '#3085d6',
              cancelButtonColor: '#d33',
              confirmButtonText: 'Aceptar',
              allowOutsideClick: false
            }).then((result) => {
                if (result.value) {
                  this.authService.logout();
                }
            });                 
          }else if (res.codigoError === 2) {
            Swal.fire('Atención',res.mensaje,'warning');
          } else {
            Swal.fire('Atención','Error al guardar la contraseña: '+res.mensaje+ '. Por favor intente más tarde o comuníquese con el administrador del sistema.','error');
          }
        });
      }else {
        Swal.fire('Atención',this.mensajeValidacion,'warning');
      }     
    }
  }
}
