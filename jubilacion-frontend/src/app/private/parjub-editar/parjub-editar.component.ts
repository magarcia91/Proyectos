import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Parjub } from 'src/app/core/models/parjub';
import { ParjubService } from 'src/app/core/services/parjub-service';

@Component({
  selector: 'app-perjub-editar',
  templateUrl: './parjub-editar.component.html',
  styleUrls: ['./parjub-editar.component.css']
})
export class ParjubEditarComponent implements OnInit {
  
  parjub : Parjub;
  parJub1: Parjub[];
  parcod: number;

  constructor(private parJubService: ParjubService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {

    this.parjub = new Parjub();

    this.parcod = this.route.snapshot.params['parcod'];
    
    this.parJubService.getItem(this.parcod)
      .subscribe(data => {
        console.log(data)
        this.parjub = data;
      }, error => console.log(error));

  }

  update() {
    this.parJubService.updateItem(this.parcod, this.parjub)
      .subscribe(data => {
        console.log(data);
        this.parjub = new Parjub();
        this.gotoList();
      }, error => console.log(error));
  }
  onSubmit() {
    this.update();    
  }

  gotoList() {
    this.router.navigate(['/jubilaciones/listar']);
  }

    /* update1() {
    this.parJubService.updateItem(this.parJub.parcod, this.parJub)
      .subscribe(data => {
        console.log(data);
        this.parJub = new Parjub();
        this.gotoList();
      }, error => console.log(error));
  } */


}
