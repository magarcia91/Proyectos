import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { AnioLectivo } from 'src/app/core/model/anio-lectivo';
import { Ponderacion } from 'src/app/core/model/ponderacion';
import { TipoEducacion } from 'src/app/core/model/tipo-educacion';
import { TitulacionService } from 'src/app/services/titulacion.service';

@Component({
  selector: 'app-editar-fechas',
  templateUrl: './editar-fechas.component.html',
  styleUrls: ['./editar-fechas.component.css']
})
export class EditarFechasComponent implements OnInit {

  
  ponderacionFormControl = new FormControl();
  form: FormGroup;
  listaTipoEducacion: Observable<TipoEducacion[]>;
  listaAnioLectivo: Observable<AnioLectivo[]>;
  ponderacion:Ponderacion;

  constructor(private titulacionService: TitulacionService, private fb: FormBuilder) { }

  ngOnInit(){

    this.form = this.fb.group({ 

      mcaCodigo:new FormControl(''),
      codRegAniLec: new FormControl(''),
      codTipoEducacion: new FormControl(''),
      denominacion: new FormControl(''),
      porcentaje: new FormControl(''),
      notmin: new FormControl(''),
      notmax: new FormControl('')
    })
    
    this.listaAnioLectivo= this.titulacionService.listAnioRegimen();
    this.listaTipoEducacion= this.titulacionService.listTipoEducacion();  
  }

  onSubmit(){  
  /*   console.log(this.form);
    this.titulacionService
    .saveFechas(this.ponderacion).subscribe(data => {
      console.log(data)
      this.ponderacion = new Ponderacion();      
    }, 
    error => console.log(error));
  }
 */
  }
}
