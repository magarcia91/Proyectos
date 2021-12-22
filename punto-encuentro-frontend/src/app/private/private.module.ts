import { ListFilterPipe } from './../shared/pipes/list-filter.pipe';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';

import { PrivateRoutingModule } from './private-routing.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { DataTablesModule } from 'angular-datatables';
import { RegistroComponent } from './registro/registro.component';
import { MaterialModule } from '../material/material.module';
import { SocioEmocionalComponent } from './socio-emocional/socio-emocional.component';
import { PedagogicoComponent } from './pedagogico/pedagogico.component'
import { NumerosDirective } from '../core/directivas/numeros/numeros.directive';
import { NgxSpinnerModule } from 'ngx-spinner';
import { CargaMasivaComponent } from './carga-masiva/carga-masiva.component';

@NgModule({
  declarations: [ 
    NumerosDirective,RegistroComponent, SocioEmocionalComponent, PedagogicoComponent, CargaMasivaComponent],
  imports: [
    CommonModule,
    PrivateRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule,
    Ng2SearchPipeModule,
    DataTablesModule,
    NgxSpinnerModule,
    /*Angular Material*/
    MaterialModule
  ]
})
export class PrivateModule { }
