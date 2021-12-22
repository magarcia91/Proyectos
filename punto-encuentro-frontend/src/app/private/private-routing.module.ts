import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CargaMasivaComponent } from './carga-masiva/carga-masiva.component';
import { PedagogicoComponent } from './pedagogico/pedagogico.component';
import { RegistroComponent } from './registro/registro.component';
import { SocioEmocionalComponent } from './socio-emocional/socio-emocional.component';

// subcarpetas

const routes: Routes = [
  
  {path: 'cargaMasiva', component: CargaMasivaComponent},
  {path: 'registro', component: RegistroComponent},
  {path: 'socioemocional', component: SocioEmocionalComponent},
  {path: 'pedagogico', component: PedagogicoComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PrivateRoutingModule { }
