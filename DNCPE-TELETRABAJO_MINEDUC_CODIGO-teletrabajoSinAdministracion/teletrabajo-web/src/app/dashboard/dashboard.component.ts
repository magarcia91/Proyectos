import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { Router } from '@angular/router';
import { Cabecera } from 'app/entity/cabecera';
import { Semana } from 'app/entity/semana';
import { ListaEncuestasDialogComponent } from 'app/pages/encuesta/dialog/lista-encuestas-dialog.component';
import { AgendaService } from 'app/services/agenda.service';
import { AuthService } from 'app/services/AuthService';
import { EncuestaService } from 'app/services/encuesta.service';
import Swal from 'sweetalert2';
import { ActividadDialogComponent } from './actividad-dialog/actividad-dialog.component';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  semanas: Semana[];
  cabecera: Cabecera;

  constructor(private authService: AuthService, public router: Router, private agendaService: AgendaService, public dialog: MatDialog, private encuestaService:EncuestaService) { }
  ngOnInit() {
    if (localStorage.getItem('token') === null) {
      localStorage.clear();
    }
    this.authService.validateLogin('dashboard');
    if (this.authService.isLoggedIn() && localStorage.getItem('cambioObligatorioClave') !== 'true') { 
      this.getCabecera();
      this.getSemanas();
    }   
  }


  getSemanas() {
    this.agendaService.getSemana().subscribe((res: any) => {
      this.semanas = res;
      console.log(this.semanas);
    });
  }

  getCabecera() {
    this.agendaService.getCabecera().subscribe((res: any) => {
      this.cabecera = res;           
      if(this.cabecera.oferta === null) {
        this.router.navigate(['/datosDocente']);
        Swal.fire('Atención','Por favor registre sus datos','info');
      }else if(localStorage.getItem('habilitadaEncuesta') == 'true' && this.cabecera.mostrarEncuesta){        
        this.listaEncuestas();
        /*this.encuestaService.getExistenPreguntasGuardadas(this.cabecera.codigoCabeceraRegistro).subscribe((res: any) => {          
          if (res.existenRespuestasGuardadas == false) {
            this.router.navigate(['encuesta']);
            Swal.fire({
              title: '¡Existe una encuesta pendiente!',
              text: "Por favor, conteste la encuesta para continuar.",
              icon: 'warning',                
              confirmButtonColor: '#3085d6',
              cancelButtonColor: '#d33',
              confirmButtonText: 'Aceptar'
            })         
          }
        });*/
      }
    });
  }

  newTask(semana) {
    const dialogRef = this.dialog.open(ActividadDialogComponent, {
      data: {semana: semana}
    });

    dialogRef.afterClosed().subscribe(result => {
      this.getSemanas();
    });

  }

  listaEncuestas() {    
    const dialogRef = this.dialog.open(ListaEncuestasDialogComponent, {
      data: {dashboard: true},
      disableClose: true,
    });    
  }

  registrarInactivarActividades(semana: any, esInactivarActividades: boolean){
    Swal.fire({      
      text:'¿Está seguro de '+(esInactivarActividades?'inactivar las actividades registradas en la semana del '+semana.fechaInicio+' al '+semana.fechaFin+'?':'registrar su semana de actividades como trabajo presencial?'),      
      icon: 'info',                
      confirmButtonColor: '#3085d6',
      showCancelButton: true,      
      allowOutsideClick: false,
      confirmButtonText: 'Aceptar',
      cancelButtonText: 'Cancelar',
      }).then((result) => {
        if (result.value) {
          if(esInactivarActividades){
            this.inactivarActividades(semana);
          }else{
            this.guardarTrabajoPresencial(semana);
          }          
        }
      });
  }

  guardarTrabajoPresencial(semana: any){
    this.agendaService.guardarTrabajoPresencial(semana).subscribe((res: any) => {          
      if(res.codigoError === 0) {                                
        Swal.fire({
          title: 'El registro fue procesado correctamente.',              
          icon: 'success',                
          confirmButtonColor: '#3085d6',
          allowOutsideClick: false,
          confirmButtonText: 'Aceptar'
        }).then((result) => {
          if (result.value) {            
            this.getSemanas();
          }
        });                     
      } else {
        Swal.fire('Atención','Error al registrar el trabajo presencial: '+res.mensaje+ '. Por favor intente más tarde o comuníquese con el administrador del sistema.','error');
      }
    });
  }

  inactivarActividades(semana: any){
    this.agendaService.inactivarActividades(semana).subscribe((res: any) => {          
      if(res.codigoError === 0) {                                
        Swal.fire({
          title: 'La inactivación de actividades fue procesada correctamente.',              
          icon: 'success',                
          confirmButtonColor: '#3085d6',
          allowOutsideClick: false,
          confirmButtonText: 'Aceptar'
        }).then((result) => {
          if (result.value) {            
            this.getSemanas();
          }
        });                     
      } else {
        Swal.fire('Atención','Error al inactivar las actividades: '+res.mensaje+ '. Por favor intente más tarde o comuníquese con el administrador del sistema.','error');
      }
    });
  }

}
