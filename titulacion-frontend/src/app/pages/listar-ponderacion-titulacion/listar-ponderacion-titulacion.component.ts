import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Ponderacion } from 'src/app/core/model/ponderacion';
import {FormBuilder, FormControl,FormGroup,Validators} from '@angular/forms';
import { TitulacionService } from 'src/app/services/titulacion.service';
import { Observable } from 'rxjs';
import { TipoEducacion } from 'src/app/core/model/tipo-educacion';
import { AnioLectivo } from 'src/app/core/model/anio-lectivo';
import { Router } from '@angular/router';
import { LocalStoragePonderacionService } from 'src/app/services/local-storage-ponderacion.service';

@Component({
  selector: 'app-listar-ponderacion-titulacion',
  templateUrl: './listar-ponderacion-titulacion.component.html',
  styleUrls: ['./listar-ponderacion-titulacion.component.css']
})
export class ListarPonderacionTitulacionComponent implements OnInit {

  ponderacionLista: any;
  displayedColumns: string[] = ['mcaCodigo', 'mcaDenominacion', 'mcaPorcentaje','mcaDesde','mcaHasta','mcaEstado','acciones'];
  dataSource = new MatTableDataSource<Ponderacion>();
  listaTipoEducacion: Observable<TipoEducacion[]>;
  listaAnioLectivo: Observable<AnioLectivo[]>;
  ponderacionForm: FormGroup;
  ponderacionFormControl = new FormControl();

  constructor(private titulacionService: TitulacionService, private fb: FormBuilder, private router:Router,private storagePonderacion:LocalStoragePonderacionService) { }

  ngOnInit() {

    this.ponderacionForm = this.fb.group({ 
      mcaCodigo:new FormControl(''),
      codRegAniLec: new FormControl(''),
      codTipoEducacion: new FormControl(''),
      mcaDenominacion: new FormControl(''),
      mcaPorcentaje: new FormControl(''),
      mcaDesde: new FormControl(''),
      mcaHasta: new FormControl(''),
      mcaEstado: new FormControl(''),      
    })

    this.listaAnioLectivo= this.titulacionService.listAnioRegimen();
    this.listaTipoEducacion= this.titulacionService.listTipoEducacion(); 
    this.list();
    this.storagePonderacion;
  }

  obtenerAnioLectivo(){
    this.titulacionService.filtroPonderacion(this.ponderacionForm.get("codRegAniLec")?.value,this.ponderacionForm.get("codTipoEducacion")?.value)
    .subscribe(
      data => {
        this.ponderacionLista=data             
      },
      error => console.log(error)); 
  } 

  list(){
    this.titulacionService.listPonderacion().subscribe(data => {
      this.dataSource = new MatTableDataSource(data);
        //console.log(data);
    });
  }

  update(ponderacion:Ponderacion){     
      this.storagePonderacion.ponderacionData=ponderacion;       
      this.router.navigate(['/guardarModeloCalificacion', ponderacion])
     
  }

  create(){
    const ponderacion={
      mcaCodigo:0,
      codRegAniLec:0,
      codTipoEducacion:0,
      mcaDenominacion:'',
      mcaEstado: 0 
    }
    this.storagePonderacion.ponderacionData=ponderacion; 
    this.router.navigate(['/guardarModeloCalificacion']);
  }
}

    /* this.titulacionService.updatePonderacion(ponderacion)
      .subscribe(
        data => {
          this.ponderacionLista=data           
          this.router.navigate(['/guardarModeloCalificacion', ponderacion.mcaCodigo]);        
        },
        error => console.log(error)); 
  } */
 

    //console.log(ponderacion)
    /* this.ponderacionStore.ponderacionSeleccionada=ponderacion;
    console.log(this.ponderacionStore.ponderacionSeleccionada);
    this.router.navigate(["/guardarModeloCalificacion"]); */

 /*  update(mcaCodigo: number){
    this.titulacionService.updatePonderacion()
      .subscribe(
        data => {
          this.ponderacionLista=data           
        },
        error => console.log(error));
  } */
  
  /* get ParCod(){  
    return this.titulacionForm.get('parcod');  
  } 

  get ParTipoJubilacion(){  
    return this.titulacionForm.get('partipojubilacion');  
  }  
 
  get ParTipoDiscapacidad(){  
    return this.titulacionForm.get('partipodiscapacodad');  
  }  

  get ParEdad(){  
    return this.titulacionForm.get('paredad');  
  }

  list(){
    this.titulacionService.listPonderacion().subscribe(data => {
      this.dataSource = new MatTableDataSource(data);
        console.log(data);
    });
  } 
/* 
  update(parJubCod: number){
    this.titulacionService.updateItem(parJubCod, this.parJub1)
      .subscribe(
        data => {
          this.parJub1=data           
        },
        error => console.log(error));
  } */


