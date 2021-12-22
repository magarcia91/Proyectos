import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AnioLectivo } from 'src/app/core/model/anio-lectivo';
import { FechasTitulacion } from 'src/app/core/model/fechas-titulacion';
import { TipoEducacion } from 'src/app/core/model/tipo-educacion';
import { LocalStorageTitulacionService } from 'src/app/services/local-storage-titulacion.service';
import { TitulacionService } from 'src/app/services/titulacion.service';


@Component({
  selector: 'app-listar-fechas-titulacion',
  templateUrl: './listar-fechas-titulacion.component.html',
  styleUrls: ['./listar-fechas-titulacion.component.css']
})
export class ListarFechasTitulacionComponent implements OnInit {

  displayedColumns: string[] = ['ftiCodigo','codTipoEducacion', 'codRegAniLec','ftiInicioGeneral','ftiFinGeneral','ftiInicioExonerado','ftiFinExonerado','ftiEstado','acciones'];
  dataSource = new MatTableDataSource<FechasTitulacion>();
  fechasFormControl = new FormControl();
  listaTipoEducacion: Observable<TipoEducacion[]>;
  listaAnioLectivo: Observable<AnioLectivo[]>;
  fechasForm: FormGroup;
  fechasTitulacionData:LocalStorageTitulacionService;
  fechasTitulacion:FechasTitulacion;

  constructor(private titulacionService:TitulacionService,private router:Router, private fb: FormBuilder, private storageFechas:LocalStorageTitulacionService) { }

  ngOnInit(){

    this.fechasForm = this.fb.group({ 

      ftiCodigo: new FormControl(''),
      codRegAniLec: new FormControl(''),
      codTipoEducacion: new FormControl(''),
      ftiEstado: new FormControl(''), 
      ftiInicioGeneral:new FormControl(''),
      ftiFinGeneral: new FormControl(''),
      ftiInicioExonerado:new FormControl(''),
      ftiFinExonerado: new FormControl('')   
    })

    this.listaAnioLectivo= this.titulacionService.listAnioRegimen();
    this.listaTipoEducacion= this.titulacionService.listTipoEducacion(); 
    this.list();
    this.storageFechas;
  }

  list(){
    this.titulacionService.listFechasTitulacion().subscribe(data => {
      this.dataSource = new MatTableDataSource(data);
        //console.log(data);
    });
  }

  update(fechasTitulacion:FechasTitulacion){     
    this.storageFechas.fechasTitulacionData=fechasTitulacion;       
    this.router.navigate(['/guardarFechaTitulacion', fechasTitulacion])
  }
 
  create(){
    const fechas={
      ftiCodigo: 0,
      codRegAniLec:0,
      codTipoEducacion:0,
      ftiInicioGeneral:new Date,
      ftiFinGeneral: new Date,
      ftiInicioExonerado: new Date,
      ftiFinExonerado: new Date,
      ftiEstado: 0 
    }
    this.storageFechas.fechasTitulacionData=fechas; 
    this.router.navigate(['/guardarFechaTitulacion']);
  }

}
