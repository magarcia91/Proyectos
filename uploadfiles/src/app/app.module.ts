import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListarUploadFilesComponent } from './pages/listar/listar-upload-files/listar-upload-files.component';
import { RegistrarUploadFilesComponent } from './pages/registrar/registrar-upload-files/registrar-upload-files.component';

@NgModule({
  declarations: [
    AppComponent,
    ListarUploadFilesComponent,
    RegistrarUploadFilesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
