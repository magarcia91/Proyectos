import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AnioLectivo } from 'src/app/core/model/anio-lectivo';
import { Ponderacion } from 'src/app/core/model/ponderacion';
import { TipoEducacion } from 'src/app/core/model/tipo-educacion';
import { LocalStoragePonderacionService } from 'src/app/services/local-storage-ponderacion.service';
import { TitulacionService } from 'src/app/services/titulacion.service';

export interface Brand {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-ponderacion-titulacion',
  templateUrl: './ponderacion-titulacion.component.html',
  styleUrls: ['./ponderacion-titulacion.component.css']
})
export class PonderacionTitulacionComponent implements OnInit {

  ponderacionFormControl = new FormControl();
  ponderacionForm: FormGroup;
  listaTipoEducacion: Observable<TipoEducacion[]>;
  listaAnioLectivo: Observable<AnioLectivo[]>;
  ponderacion:Ponderacion;
  
  constructor(private titulacionService: TitulacionService, private router:Router, private fb: FormBuilder, private storagePonderacion:LocalStoragePonderacionService) { }

  ngOnInit() {

    this.ponderacionForm = this.fb.group({ 
      mcaCodigo: new FormControl(''),
      codRegAniLec: new FormControl(''),
      codTipoEducacion: new FormControl(''),
      mcaDenominacion: new FormControl(''),
      mcaPorcentaje: new FormControl(''),
      mcaDesde: new FormControl(''),
      mcaHasta: new FormControl(''),
      mcaEstado: new FormControl('')
    })
   
    this.listaAnioLectivo= this.titulacionService.listAnioRegimen();
    this.listaTipoEducacion= this.titulacionService.listTipoEducacion();    
    console.log(this.storagePonderacion.ponderacion); 

    if(this.storagePonderacion.ponderacion!=null){
    
        this.ponderacionForm.get("mcaCodigo")?.setValue(this.storagePonderacion.ponderacion.mcaCodigo);
        this.ponderacionForm.get("codRegAniLec")?.setValue(this.storagePonderacion.ponderacion.codRegAniLec);
        this.ponderacionForm.get("codTipoEducacion")?.setValue(this.storagePonderacion.ponderacion.codTipoEducacion);
        this.ponderacionForm.get("mcaDenominacion")?.setValue(this.storagePonderacion.ponderacion.mcaDenominacion);
        this.ponderacionForm.get("mcaPorcentaje")?.setValue(this.storagePonderacion.ponderacion.mcaPorcentaje);
        this.ponderacionForm.get("mcaDesde")?.setValue(this.storagePonderacion.ponderacion.mcaDesde);
        this.ponderacionForm.get("mcaHasta")?.setValue(this.storagePonderacion.ponderacion.mcaHasta);
        this.ponderacionForm.get("mcaEstado")?.setValue(this.storagePonderacion.ponderacion.mcaEstado);            
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

    const ponderacion= {
      mcaCodigo:this.ponderacionForm.get("mcaCodigo")?.value,
      codRegAniLec:this.ponderacionForm.get("codRegAniLec")?.value,
      codTipoEducacion: this.ponderacionForm.get("codTipoEducacion")?.value,
      mcaDenominacion: this.ponderacionForm.get("mcaDenominacion")?.value,
      mcaPorcentaje: this.ponderacionForm.get("mcaPorcentaje")?.value,
      mcaDesde: this.ponderacionForm.get("mcaDesde")?.value,
      mcaHasta: this.ponderacionForm.get("mcaHasta")?.value,
      mcaEstado:this.ponderacionForm.get("mcaEstado")?.value?1:0
    }

    this.titulacionService.savePonderacion(ponderacion).subscribe(data => {
      console.log(data) 
      this.gotoList();              
    },     
    error => console.log(error));    
  } 

  gotoList() {
    this.router.navigate(['/listarModelo']);
  }
}

/*   actualizarPonderacion(){

    const ponderacion= {

      mcaCodigo:this.ponderacionForm.controls['mcaCodigo'].setValue("mcaCodigo"),     
      codRegAniLec:this.ponderacionForm.controls['codRegAniLec'].setValue("codRegAniLec"),      
      codTipoEducacion:this.ponderacionForm.controls['codTipoEducacion'].setValue("codTipoEducacion"),
      mcaDenominacion:this.ponderacionForm.controls['mcaDenominacion'].setValue("mcaDenominacion"),   
      mcaPorcentaje:this.ponderacionForm.controls['mcaPorcentaje'].setValue("mcaPorcentaje"),
      mcaDesde:this.ponderacionForm.controls['mcaDesde'].setValue("mcaDesde"),      
      mcaHasta:this.ponderacionForm.controls['mcaHasta'].setValue("mcaHasta"),      
      mcaEstado:this.ponderacionForm.controls['mcaEstado'].setValue("mcaEstado")         
    }

    this.titulacionService.updatePonderacion(this.ponderacion).subscribe(data => {
      console.log(data) 
      this.gotoList();              
    },     
    error => console.log(error)); 
  } */

  /* onSubmit(){  

    const ponderacion= { 
      codRegAniLec:this.ponderacionForm.get("codRegAniLec")?.value*1,
      codTipoEducacion: this.ponderacionForm.get("codTipoEducacion")?.value*1,
      mcaDenominacion: this.ponderacionForm.get("mcaDenominacion")?.value,
      mcaPorcentaje: this.ponderacionForm.get("mcaPorcentaje")?.value*1,
      mcaDesde: this.ponderacionForm.get("mcaDesde")?.value*1,
      mcaHasta: this.ponderacionForm.get("mcaHasta")?.value*1,
      mcaEstado: this.ponderacionForm.get("mcaEstado")?.value?1:0
    }   

    console.log(ponderacion);
    this.titulacionService.saveDataPonderacion(ponderacion).subscribe(data => {
      console.log(data) 
      this.gotoList();              
    },     
    error => console.log(error));    
 } */  

 /* brands: Brand[] = [
    { value: 'Louis Vuitton', viewValue: 'Louis Vuitton' },
    { value: 'Gucci', viewValue: 'Gucci' },
    { value: 'Prada', viewValue: 'Prada' },
    { value: 'Chanel', viewValue: 'Chanel' },
  ];*/

 /* this.form = this.fb.group({      
       listaAnioLectivo:[''],
       listaTipoEducacion:[''],
       denominacion: [''],
       porcentaje: [''],
       notmin: [''],
       notmax: [''],
     });*/