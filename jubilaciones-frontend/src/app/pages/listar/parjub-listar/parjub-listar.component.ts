import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Observable, Subject } from 'rxjs';
import { Parjub } from 'src/app/model/parjub';
import { ParjubService } from 'src/app/service/parjub-service';
import {FormBuilder, FormControl,FormGroup,Validators} from '@angular/forms';  
import { LocalStorageJubilacionesService } from 'src/app/service/local-storage-jubilaciones.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-parjub-listar',
  templateUrl: './parjub-listar.component.html',
  styleUrls: ['./parjub-listar.component.css']
})
export class ParjubListarComponent implements OnInit {

  parJub: Parjub[];
  parJub1: any;
  displayedColumns: string[] = ['parcod', 'partipojubilacion', 'partipodiscapacidad', 'paredad', 'partiemposervicio', 'parminaportaciones','acciones'];
  dataSource = new MatTableDataSource<Parjub>();
  parjubUpdForm: FormGroup;
  
  constructor(private parJubService: ParjubService,private router:Router,private fb: FormBuilder, private storageJubilaciones:LocalStorageJubilacionesService) { }
  
  parjubs: Observable<Parjub[]>;  
  parjub : Parjub=new Parjub();  
  parjubList:any;  
  isUpdated = false;    

  ngOnInit() {  
    
    this.parjubUpdForm = this.fb.group({ 
      parcod: new FormControl(''),
      partipojubilacion: new FormControl(''),
      partipodiscapacidad: new FormControl(''),
      paredad: new FormControl(''),
      partiemposervicio: new FormControl(''),
      parminaportaciones: new FormControl(''),      
      parestado: new FormControl('')
    })
    
      this.list();  
  }


  changeisUpdate(){  
    this.isUpdated=false;  
  } 

  list(){
    this.parJubService.list().subscribe(data => {
      this.dataSource = new MatTableDataSource(data);
        console.log(data);
    });
  }
  
  update(parJubilaciones:Parjub){     
      this.storageJubilaciones.jubilacionesData=parJubilaciones;       
      this.router.navigate(['/jubilaciones/registrar', parJubilaciones])
    
  }

  create(){
    const parJubilaciones={
      parcod:0,
      partipojubilacion:0,
      partipodiscapacidad:0,
      paredad:0,
      partiemposervicio:0,
      parminaportaciones:0,     
      parestado: 0 
    }
    this.storageJubilaciones.jubilacionesData=parJubilaciones; 
    this.router.navigate(['/jubilaciones/registrar']);
  }
}

  /* get ParCod(){  
    return this.parjubUpdForm.get('parcod');  
  } 

  get ParTipoJubilacion(){  
    return this.parjubUpdForm.get('partipojubilacion');  
  }  
 
  get ParTipoDiscapacidad(){  
    return this.parjubUpdForm.get('partipodiscapacidad');  
  }  

  get ParEdad(){  
    return this.parjubUpdForm.get('paredad');  
  }
}

  update(parJubCod: number){
    this.parJubService.updateItem(parJubCod, this.parJub1)
      .subscribe(
        data => {
          this.parJub1=data           
        },
        error => console.log(error));
  } 
  
    updateParJub(){      
    this.parJubService.updateItem(this.parjub.parcod,this.parjub).subscribe(  
     data => {       
       this.isUpdated=true;  
       this.parJubService.list().subscribe(data =>{  
         this.parjubs =data  
         })  
     },  
     error => console.log(error));  
   }   
  
  */
