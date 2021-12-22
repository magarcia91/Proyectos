import { Component, Inject, OnInit } from "@angular/core";
import { MatDialogRef, MAT_DIALOG_DATA } from "@angular/material";
import { Router } from "@angular/router";
import { AuthService } from "app/services/AuthService";
import { EncuestaService } from "app/services/encuesta.service";
import Swal from "sweetalert2";

@Component({
    selector: 'app-lista-encuestas-dialog',
    templateUrl: 'lista-encuestas-dialog.component.html',
    styleUrls: ['lista-encuestas.component.scss']
})
export class ListaEncuestasDialogComponent implements OnInit {
    
    listaEncuestas:any[]; 
    esPeticionDashboard:boolean;    

    constructor(
        public dialogRef: MatDialogRef<ListaEncuestasDialogComponent>,
        @Inject(MAT_DIALOG_DATA) public data: any,
        private encuestaService: EncuestaService,
        private authService: AuthService,
        public router: Router) {  
        this.esPeticionDashboard = data.dashboard;            
    }
    ngOnInit(): void {           
        this.listarEncuestasHabilitadas();           
    }
   
    listarEncuestasHabilitadas(){
        this.encuestaService.getEncuestasHabilitadas(localStorage.getItem('identificacion')).subscribe((resultado: any[])=>{                       
            this.listaEncuestas = resultado;   
            if(this.esPeticionDashboard){
                var encuestasNoConfirmadas: any[] = this.listaEncuestas.filter(encuesta => encuesta.estadoEncuesta != 'C');                             
                if(encuestasNoConfirmadas.length == 0){
                    this.cerrarListaEncuestas();
                }
            }                     
        },
            error => {
                if (error.error.message === 'Access Denied') {
                    this.authService.lanzarDialogoExpirarSesion();
                }
            }
        );
    }

    abrirEncuesta(codigoEncuesta:any, estadoEncuesta:any, codigoEstadoEncuesta:any){        
        localStorage.setItem('codigoEncuesta', codigoEncuesta);
        localStorage.setItem('estadoEncuesta', estadoEncuesta);
        localStorage.setItem('codigoEstadoEncuesta', (codigoEstadoEncuesta!=null?codigoEstadoEncuesta:0));        
        this.dialogRef.close();
        if(this.esPeticionDashboard){
            this.router.navigate(['encuesta']);
        }else{
            location.reload();
        }        
    }

    cerrarListaEncuestas(){    
        this.dialogRef.close();    
        this.router.navigate(['dashboard']);        
    }
        
}
