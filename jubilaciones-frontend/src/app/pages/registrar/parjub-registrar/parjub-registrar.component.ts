import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Parjub } from 'src/app/model/parjub';
import { Partipojubilacion } from 'src/app/model/partipojubilacion';
import { LocalStorageJubilacionesService } from 'src/app/service/local-storage-jubilaciones.service';
import { ParjubService } from 'src/app/service/parjub-service';


@Component({
  selector: 'app-parjub-registrar',
  templateUrl: './parjub-registrar.component.html',
  styleUrls: ['./parjub-registrar.component.css']
})

export class ParjubRegistrarComponent implements OnInit {
   
  //parjubilaciones: Parjub = new Parjub(); 
  parJubilacion: Parjub;
  partipojubilacion: any=[]; 
  partipodiscapacidad: any=[];
  tipoJubilacion: any=[];
  tipoDiscapacidad: any=[];
  jubilacionesFormControl = new FormControl();
  jubilacionesForm: FormGroup;  
  jubilaciones:Partipojubilacion;
  parTipoJubilacion: Partipojubilacion;
  submitted = false;

  constructor(private parJubService: ParjubService,private fb: FormBuilder,private router:Router, private storageJubilaciones:LocalStorageJubilacionesService) {

  }

  ngOnInit() {

    this.jubilacionesForm = this.fb.group({ 
      parcod: new FormControl(''),
      partipojubilacion: new FormControl(''),
      partipodiscapacidad: new FormControl(''),
      paredad: new FormControl(''),
      partiemposervicio: new FormControl(''),
      parminaportaciones: new FormControl(''),      
      parestado: new FormControl('')
    })

    this.partipojubilacion= this.parJubService.listTipoJubilacion();
    this.partipodiscapacidad= this.parJubService.listTipoDiscapacidad();
    this.cargarTipoJubilacion();
    this.cargarTipoDiscapacidad();

    console.log(this.storageJubilaciones.parJubilaciones); 

    if(this.storageJubilaciones.parJubilaciones!=null){   
        
        this.jubilacionesForm.get("parcod")?.setValue(this.storageJubilaciones.parJubilaciones.parcod);
        this.jubilacionesForm.get("partipojubilacion")?.setValue(this.storageJubilaciones.parJubilaciones.partipojubilacion);
        this.jubilacionesForm.get("partipodiscapacidad")?.setValue(this.storageJubilaciones.parJubilaciones.partipodiscapacidad);
        this.jubilacionesForm.get("paredad")?.setValue(this.storageJubilaciones.parJubilaciones.paredad);
        this.jubilacionesForm.get("partiemposervicio")?.setValue(this.storageJubilaciones.parJubilaciones.partiemposervicio);
        this.jubilacionesForm.get("parminaportaciones")?.setValue(this.storageJubilaciones.parJubilaciones.parminaportaciones);
        this.jubilacionesForm.get("parestado")?.setValue(this.storageJubilaciones.parJubilaciones.parestado);            
    }
  }  
    
  onSubmit(){
    
    const parametrosJub = { 
      parcod: this.jubilacionesForm.get("parcod")?.value,
      partipojubilacion:this.jubilacionesForm.get("partipojubilacion")?.value,
      partipodiscapacidad: this.jubilacionesForm.get("partipodiscapacidad")?.value,
      paredad:this.jubilacionesForm.get("paredad")?.value, 
      partiemposervicio: this.jubilacionesForm.get("partiemposervicio")?.value,
      parminaportaciones: this.jubilacionesForm.get("parminaportaciones")?.value,
      parestado: this.jubilacionesForm.get("parestado")?.value?1:0          
    }    

    console.log(parametrosJub);
    this.parJubService.saveJubilaciones(parametrosJub).subscribe(data => {
      console.log(data) 
      this.gotoList();              
    },     
    error => console.log(error));
    
    /*:Parjub = new Parjub();
    parametrosJub.partipojubilacion=this.jubilacionesForm.get("partipojubilacion")?.value;
    parametrosJub.partipodiscapacidad=this.jubilacionesForm.get("partipodiscapacidad")?.value;
    parametrosJub.paredad = this.jubilacionesForm.get("paredad")?.value;
    parametrosJub.partiemposervicio= this.jubilacionesForm.get("partiemposervicio")?.value;
    parametrosJub.parminaportaciones= this.jubilacionesForm.get("parminaportaciones")?.value;
    parametrosJub.parestado=this.jubilacionesForm.get("parestado")?.value?1:0;*/ 
    
  } 
  gotoList() {
    this.router.navigate(['/jubilaciones/listar']);
  }  

  cargarTipoJubilacion(){
    this.parJubService.listTipoJubilacion().subscribe(data => {
      this.tipoJubilacion=data;
        //console.log(data);
    });
  }

  cargarTipoDiscapacidad(){
    this.parJubService.listTipoDiscapacidad().subscribe(data => {
      this.tipoDiscapacidad=data;
        //console.log(data);
    });
  }

  changeTipJub() { 
    this.jubilaciones= this.jubilacionesForm.get("partipojubilacion")?.value;
    this.parJubService.listTipoDiscapacidadPorTipoJubilacion(this.jubilaciones).subscribe(
      data => {
        this.tipoDiscapacidad = data;       
    });
	} 
}

//console.log(this.jubilacionesForm.get("partipojubilacion")?.value);
/*   guardarInscripcionJubilacion(){  
    
    this.parjubilaciones.partipojubilacion= this.partipojubilacion
    this.parjubilaciones.partipodiscapacidad= this.partipojubilacion
    console.log(this.parjubilaciones);
    
    this.parJubService.createItem(this.parjubilaciones).subscribe(data => {
        console.log(data)         
        this.gotoList();
      }, 
      error => console.log(error));
    }
  } */
/* create() {
    this.parJubService.createItem(this.parjubilaciones).subscribe(data => {
      console.log(data)
      this.parjubilaciones = new Parjub();
      this.gotoList();
    }, 
    error => console.log(error));
  } */

/*   partipojubilacion: Array<any> = [
		{ id:1 , name: 'Voluntaria',partipodiscapacidad: [ {id:3, name: 'Ninguna'}]},
		{ id:2 , name: 'Especial', partipodiscapacidad: [ {id:1, name: 'Vejez'},{id:2, name:'Invalidez'} ]},
		{ id:3 , name: 'Invalidez',partipodiscapacidad: [ {id:3, name: 'Ninguna'}]},
		{ id:4 , name: 'Obligatoria',partipodiscapacidad: [ {id:3, name: 'Ninguna'}]}
	]; 
  partipodiscapacidad: Array<any> = [];  */ 
/*   selectedTipJub: String = "Seleccione el tipo de jubilacion";
  selectedTipDis: String = "Seleccione el tipo de discapacidad"; */
  