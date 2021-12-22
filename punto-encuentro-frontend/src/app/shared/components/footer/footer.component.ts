import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss']
})
export class FooterComponent implements OnInit {

  constructor() { }

  public autor: any = {nombre: 'Ministerio', apellido: 'Educacion'};

  ngOnInit(): void {
  }

}
