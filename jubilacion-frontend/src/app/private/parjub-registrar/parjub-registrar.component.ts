import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Parjub } from 'src/app/core/models/parjub';
import { ParjubService } from 'src/app/core/services/parjub-service';

@Component({
  selector: 'app-parjub-registrar',
  templateUrl: './parjub-registrar.component.html',
  styleUrls: ['./parjub-registrar.component.css']
})
export class ParjubRegistrarComponent implements OnInit {

  parJub: Parjub;
  parjub: Parjub = new Parjub();
  submitted = false;
  parjub1: Object = {};
 
  constructor(private parJubService: ParjubService,private fb: FormBuilder,private router:Router) { }

  ngOnInit() {

  }  

  newParJub(): void {
    this.submitted = false;
    this.parjub = new Parjub();
  }

  onSubmit(){
    this.submitted = true;
    this.create();
  } 

  create() {
    this.parJubService
    .createItem(this.parjub).subscribe(data => {
      console.log(data)
      this.parjub = new Parjub();
      this.gotoList();
    }, 
    error => console.log(error));
  }


  gotoList() {
    this.router.navigate(['/jubilaciones/listar']);
  }
  


  

}
