import { Component, OnInit, Inject } from '@angular/core';
import { Actividad } from 'app/entity/actividad';
import { AgendaService } from 'app/services/agenda.service';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Semana } from 'app/entity/semana';
import Swal from 'sweetalert2';
import { AuthService } from 'app/services/AuthService';

@Component({
  selector: 'app-actividad-dialog',
  templateUrl: './actividad-dialog.component.html',
  styleUrls: ['./actividad-dialog.component.scss']
})
export class ActividadDialogComponent implements OnInit {

  actividades: Actividad[];
  registro: Semana;
  actividadesSeleccionadas: Actividad[];

  constructor(public dialogRef: MatDialogRef<ActividadDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any, private agendaService: AgendaService, private authService: AuthService) {
      this.registro = data.semana;
     }

  ngOnInit() {
    if (localStorage.getItem('token') === null) {
      localStorage.clear();
    }
    this.authService.validateLogin('dashboard');
    if (this.authService.isLoggedIn()) { 
      this.actividadesSeleccionadas = new Array();
      this.obtenerActividades();
    }    
  }

  obtenerActividades() {
    this.agendaService.getActivities().subscribe((res: any) => {
      this.actividades = res;
      if(this.registro.actividades.length > 0) {
        this.actividadesSeleccionadas = this.registro.actividades;
        this.checkActivities();
      }
    });
  }

  checkActivities() {
    for(let i = 0; i<this.actividadesSeleccionadas.length; i++) {
      for(let j= 0; j< this.actividades.length; j++) {
        if(this.actividadesSeleccionadas[i].codigo === this.actividades[j].codigo) {
          this.actividades[j].check = true;
        }
      }
    }
  }

  checkChange(event, actividad) {
    console.log(event);
    console.log(actividad);
    if(event.checked) {
      this.actividadesSeleccionadas.push(actividad);
    } else {
      const index = this.getActividadForList(actividad);
      if (index > -1) {
        this.actividadesSeleccionadas.splice(index, 1);
      }
    }
  }

  checkChangeAll(event) {
    if(event.checked) {
      this.actividadesSeleccionadas = this.actividades;
      this.putCheckAll(true);
    } else {
      this.actividadesSeleccionadas = new Array();
      this.putCheckAll(false);
    }
  }

  putCheckAll(value) {
        for(let j= 0; j< this.actividades.length; j++) {
            this.actividades[j].check = value;
        }
  }

  getActividadForList(actividad) {
    let index = -1;
    for(let i = 0; i<this.actividadesSeleccionadas.length; i++) {
      if(this.actividadesSeleccionadas[i].codigo === actividad.codigo) {
        index = i;
      }
    }
    return index;
  }

  save() {
    if(this.actividadesSeleccionadas.length > 0) {
      this.registro.actividades = this.actividadesSeleccionadas;
      this.saveActividades();
    } else {
      Swal.fire('Atención','Debe seleccionar al menos una actividad','warning');
    }
  }

  saveActividades() {
    this.agendaService.save(this.registro).subscribe((res: any) => {
      if(res.codigoError === 0) {
        Swal.fire('Atención','Actividades registradas correctamente','success');
        this.dialogRef.close();
      } else {
        Swal.fire('Atención','Error al registrar actividades: '+res.mensaje,'error');
      }
    });
  }

}
