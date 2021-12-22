import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { ParjubListarComponent } from './pages/listar/parjub-listar/parjub-listar.component';
import { ParjubEditarComponent } from './pages/editar/parjub-editar/parjub-editar.component';
import { ParjubEliminarComponent } from './pages/eliminar/parjub-eliminar/parjub-eliminar.component';
import { ParjubRegistrarComponent } from './pages/registrar/parjub-registrar/parjub-registrar.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatDividerModule} from '@angular/material/divider';
import {MatListModule} from '@angular/material/list';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatCardModule } from '@angular/material/card';
import {MatTableModule} from '@angular/material/table';
import {DataTablesModule} from 'angular-datatables';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatSelectModule} from '@angular/material/select';
import { MatCheckboxModule } from '@angular/material/checkbox'
import { LoginComponent } from './pages/login/login/login.component';  

@NgModule({
  declarations: [
    AppComponent,    
    ParjubListarComponent,
    ParjubEditarComponent,
    ParjubEliminarComponent,
    ParjubRegistrarComponent,
    LoginComponent       
  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatSidenavModule,
    MatButtonModule,
    MatIconModule,
    MatDividerModule,
    MatListModule,
    MatFormFieldModule,
    MatInputModule,
    MatCardModule,
    MatTableModule,
    MatExpansionModule,
    MatSelectModule,
    MatCheckboxModule,
    DataTablesModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
