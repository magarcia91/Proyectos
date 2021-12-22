import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AnioLectivo } from 'src/app/core/model/anio-lectivo';
import { FechasTitulacion } from 'src/app/core/model/fechas-titulacion';
import { TipoEducacion } from 'src/app/core/model/tipo-educacion';
import { LocalStorageTitulacionService } from 'src/app/services/local-storage-titulacion.service';
import { TitulacionService } from 'src/app/services/titulacion.service';

export interface Brand {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-fechas-titulacion',
  templateUrl: './fechas-titulacion.component.html',
  styleUrls: ['./fechas-titulacion.component.css']
})
export class FechasTitulacionComponent implements OnInit {

  fechasFormControl = new FormControl();
  fechasForm: FormGroup;
  listaTipoEducacion: Observable<TipoEducacion[]>;
  listaAnioLectivo: Observable<AnioLectivo[]>;
  fechasTitulacion:FechasTitulacion;
  
  constructor(private titulacionService: TitulacionService, private router:Router, private fb: FormBuilder,private storageFechas:LocalStorageTitulacionService) { }

  ngOnInit() {

    this.fechasForm = this.fb.group({ 
      codRegAniLec: new FormControl(''),
      codTipoEducacion: new FormControl(''),
      ftiCodigo: new FormControl(''),
      ftiEstado: new FormControl(''), 
      ftiInicioGeneral:new FormControl(''),
      ftiFinGeneral: new FormControl(''),
      ftiInicioExonerado:new FormControl(''),
      ftiFinExonerado: new FormControl('') 
    })
   
    this.listaAnioLectivo= this.titulacionService.listAnioRegimen();
    this.listaTipoEducacion= this.titulacionService.listTipoEducacion();
    console.log(this.storageFechas.fechasTitulacion);  
    
      if(this.storageFechas.fechasTitulacion.ftiCodigo!==0){
    
        this.fechasForm.get("ftiCodigo")?.setValue(this.storageFechas.fechasTitulacion.ftiCodigo);
        this.fechasForm.get("codRegAniLec")?.setValue(this.storageFechas.fechasTitulacion.codRegAniLec);
        this.fechasForm.get("codTipoEducacion")?.setValue(this.storageFechas.fechasTitulacion.codTipoEducacion);
        this.fechasForm.get("ftiInicioGeneral")?.setValue(this.storageFechas.fechasTitulacion.ftiInicioGeneral);
        this.fechasForm.get("ftiFinGeneral")?.setValue(this.storageFechas.fechasTitulacion.ftiFinGeneral);
        this.fechasForm.get("ftiInicioExonerado")?.setValue(this.storageFechas.fechasTitulacion.ftiInicioExonerado);
        this.fechasForm.get("ftiFinExonerado")?.setValue(this.storageFechas.fechasTitulacion.ftiFinExonerado);
        this.fechasForm.get("ftiEstado")?.setValue(this.storageFechas.fechasTitulacion.ftiEstado);            
    }
  }

  cargarAnioLectivo() {
    this.titulacionService.listAnioRegimen().subscribe(anioLectivos => {
      this.listaAnioLectivo = anioLectivos;
      console.log("Regimen");
    });
  }

  cargarTipoEducacion() {
    this.titulacionService.listTipoEducacion().subscribe(tipoEducaciones => {
      this.listaTipoEducacion = tipoEducaciones;
      console.log("Tipo Educacion");      
    });
  }

  onSubmit(){  

    const fechas= { 
      ftiCodigo: this.fechasForm.get("ftiCodigo")?.value,
      codRegAniLec:this.fechasForm.get("codRegAniLec")?.value*1,
      codTipoEducacion: this.fechasForm.get("codTipoEducacion")?.value*1,
      ftiInicioGeneral: this.fechasForm.get("ftiInicioGeneral")?.value,
      ftiFinGeneral: this.fechasForm.get("ftiFinGeneral")?.value,
      ftiInicioExonerado: this.fechasForm.get("ftiInicioExonerado")?.value,
      ftiFinExonerado: this.fechasForm.get("ftiFinExonerado")?.value,
      ftiEstado: this.fechasForm.get("ftiEstado")?.value?1:0      
    }   

    console.log(fechas);
    this.titulacionService.saveFechas(fechas).subscribe(data => {
      console.log(data) 
      this.gotoList();              
    },     
    error => console.log(error));    
  } 

  gotoList() {
    this.router.navigate(['/listar']);
  }
}

 // brands: Brand[] = [
 //   { value: 'Louis Vuitton', viewValue: 'Louis Vuitton' },
 //   { value: 'Gucci', viewValue: 'Gucci' },
 //   { value: 'Prada', viewValue: 'Prada' },
 //   { value: 'Chanel', viewValue: 'Chanel' },
 // ];

 // this.form = this.fb.group({      
    //   listaAnioLectivo:[''],
    //   listaTipoEducacion:[''],
    //   denominacion: [''],
    //   porcentaje: [''],
    //   notmin: [''],
    //   notmax: [''],
    // });