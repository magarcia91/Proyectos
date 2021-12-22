import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Observable, Subject } from 'rxjs';
import { Parjub } from 'src/app/core/models/parjub';
import { ParjubService } from 'src/app/core/services/parjub-service';
import {FormControl,FormGroup,Validators} from '@angular/forms';  

@Component({
  selector: 'app-perjub-listar',
  templateUrl: './parjub-listar.component.html',
  styleUrls: ['./parjub-listar.component.css']
})
export class ParjubListarComponent implements OnInit {

  parJub: Parjub[];
  parJub1: any;
  displayedColumns: string[] = ['parcod', 'partipojubilacion', 'partipodiscapacidad', 'paredad', 'partiemposervicio', 'parminaportaciones','acciones'];
  dataSource = new MatTableDataSource<Parjub>();
  
  constructor(private parJubService: ParjubService) { }
  
  parjubs: Observable<Parjub[]>;  
  parjub : Parjub=new Parjub();  
  parjubList:any;  
  isUpdated = false;    

  ngOnInit() {    
    
      this.list();  
      
  }

  parjubUpdForm=new FormGroup({  
    parcod:new FormControl(),  
    partipojubilacion:new FormControl(),  
    partipodiscapacidad:new FormControl(),  
    paredad:new FormControl()  
  });  
  

  list(){
    this.parJubService.list().subscribe(data => {
      this.dataSource = new MatTableDataSource(data);
        console.log(data);
    });
  }
  
  updateParJub(){      
   this.parJubService.updateItem(this.parjub.parcod,this.parjub).subscribe(  
    data => {       
      this.isUpdated=true;  
      this.parJubService.list1().subscribe(data =>{  
        this.parjubs =data  
        })  
    },  
    error => console.log(error));  
  }   
  

  changeisUpdate(){  
    this.isUpdated=false;  
  } 
  

  get ParCod(){  
    return this.parjubUpdForm.get('parcod');  
  } 

  get ParTipoJubilacion(){  
    return this.parjubUpdForm.get('partipojubilacion');  
  }  
 
  get ParTipoDiscapacidad(){  
    return this.parjubUpdForm.get('partipodiscapacodad');  
  }  

  get ParEdad(){  
    return this.parjubUpdForm.get('paredad');  
  }

 
  update(parJubCod: number){
    this.parJubService.updateItem(parJubCod, this.parJub1)
      .subscribe(
        data => {
          this.parJub1=data           
        },
        error => console.log(error));
  }

}
