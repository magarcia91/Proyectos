import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MatFormFieldModule} from '@angular/material/form-field';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatNativeDateModule, MatOptionModule } from '@angular/material/core';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule} from '@angular/material/button';
import { MatSelectModule} from '@angular/material/select';
import { MatToolbarModule} from '@angular/material/toolbar';
import { MatSidenavModule} from '@angular/material/sidenav';
import { MatListModule} from '@angular/material/list'; 
import { MatIconModule} from '@angular/material/icon';
import { MatExpansionModule} from '@angular/material/expansion';
import { MatTableModule} from '@angular/material/table';
import { DataTablesModule} from 'angular-datatables';
import { MatCardModule } from '@angular/material/card';
import { MatCheckboxModule} from '@angular/material/checkbox';
import { MatDatepickerModule} from '@angular/material/datepicker';
import { NgxSpinnerModule } from 'ngx-spinner';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { ListarPonderacionTitulacionComponent } from './pages/listar-ponderacion-titulacion/listar-ponderacion-titulacion.component';
import { EditarFechasComponent } from './pages/editar-fechas/editar-fechas/editar-fechas.component';
import { FechasTitulacionComponent } from './pages/fechas-titulacion/fechas-titulacion.component';
import { ConsejoTitulacionComponent } from './pages/consejo-ejecutivo/consejo-ejecutivo.component';
import { PonderacionTitulacionComponent } from './pages/ponderacion-titulacion/ponderacion-titulacion.component';
import { ListarFechasTitulacionComponent } from './pages/listar-fechas-titulacion/listar-fechas-titulacion.component';

@NgModule({
  declarations: [
    AppComponent,
    PonderacionTitulacionComponent,
    FechasTitulacionComponent,
    ListarPonderacionTitulacionComponent,
    ConsejoTitulacionComponent,    
    EditarFechasComponent, 
    ListarFechasTitulacionComponent
  ],
  
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatOptionModule,
    MatButtonModule,
    MatSelectModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    MatIconModule,
    MatExpansionModule,
    MatTableModule,
    MatCardModule,
    MatCheckboxModule,  
    MatDatepickerModule, 
    MatNativeDateModule,
    NgxSpinnerModule,
    MatAutocompleteModule,    
    DataTablesModule.forRoot()   
  ],

   exports: [
    MatSelectModule,
    MatFormFieldModule,
    MatInputModule,
    MatToolbarModule,
    MatIconModule,
    MatTableModule,    
    MatSelectModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,  
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
