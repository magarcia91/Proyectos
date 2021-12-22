import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import { Observable } from 'rxjs';
import { AnioLectivo } from 'src/app/core/model/anio-lectivo';
import { ConsejoEjecutivo } from 'src/app/core/model/consejo-ejecutivo';
import { TipoEducacion } from 'src/app/core/model/tipo-educacion';

@Component({
  selector: 'app-consejo-titulacion',
  templateUrl: './consejo-ejecutivo.component.html',
  styleUrls: ['./consejo-ejecutivo.component.css']
})
export class ConsejoTitulacionComponent implements OnInit {

  
  displayedColumns: string[] = ['ftiCodigo', 'listaAnioLectivo', 'denominacion', 'porcentaje', 'notmax','notmin','acciones'];
  dataSource = new MatTableDataSource<ConsejoEjecutivo>();
  listaTipoEducacion: Observable<TipoEducacion[]>;
  listaAnioLectivo: Observable<AnioLectivo[]>;
  titulacionForm: FormGroup;
  ponderacionFormControl = new FormControl();
  
  constructor() { }

  ngOnInit(): void {
  }

}
