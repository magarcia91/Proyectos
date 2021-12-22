import { NgModule } from '@angular/core';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ComponentsComponent } from './components/components.component';
import { HttpClientModule } from '@angular/common/http';
import { ListarContactoComponent } from './components/listar-contacto/listar-contacto.component';
import { ContactoEmailComponent } from './components/contacto-email/contacto-email.component';


@NgModule({
  declarations: [
    AppComponent,
    ComponentsComponent,   
    ContactoEmailComponent, 
    ListarContactoComponent,
    
  
  ],
  imports: [ 
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
