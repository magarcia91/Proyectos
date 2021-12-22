import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListarUploadFilesComponent } from './pages/listar/listar-upload-files/listar-upload-files.component';
import { RegistrarUploadFilesComponent } from './pages/registrar/registrar-upload-files/registrar-upload-files.component';

const routes: Routes = [
  { path: "", redirectTo: "/", pathMatch: "full" },
  { path: 'listfiles', component: ListarUploadFilesComponent, data: { title: "Detalle de Archivos " } },
  { path: 'uploadfile', component: RegistrarUploadFilesComponent, data: { title: "Subir Archivos" } },
   
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
