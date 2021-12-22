import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Parjub } from 'src/app/model/parjub';
import { ParjubService } from 'src/app/service/parjub-service';

@Component({
  selector: 'app-parjub-eliminar',
  templateUrl: './parjub-eliminar.component.html',
  styleUrls: ['./parjub-eliminar.component.css']
})
export class ParjubEliminarComponent implements OnInit {
  
  deleteMessage: boolean;
  parJub : Parjub[];

  constructor(private parJubService: ParjubService) { }

  ngOnInit(): void {
  }

  delete(parJubCod: number) {
    this.parJubService.deleteItem(parJubCod)
      .subscribe(
        data => {
          console.log(data);
          this.deleteMessage=true;
          this.parJubService.list().subscribe(data =>{
            this.parJub =data
            })
        },
        error => console.log(error));
  }


}
