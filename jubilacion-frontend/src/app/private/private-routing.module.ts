import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CargaMasivaComponent } from './carga-masiva/carga-masiva.component';
import { ParjubEditarComponent } from './parjub-editar/parjub-editar.component';
import { ParjubListarComponent } from './parjub-listar/parjub-listar.component';
import { ParjubRegistrarComponent } from './parjub-registrar/parjub-registrar.component'; 
import { PedagogicoComponent } from './pedagogico/pedagogico.component';
import { RegistroComponent } from './registro/registro.component';
import { SocioEmocionalComponent } from './socio-emocional/socio-emocional.component';

// subcarpetas

const routes: Routes = [
  
  { path: 'jubilaciones/listar', component: ParjubListarComponent, data: { title: "Inscripciones" } },
  { path: 'jubilaciones/modificar/:parcod', component: ParjubEditarComponent, data: { title: "Actualizar Inscripciones" } },
  { path: 'jubilaciones/registrar', component: ParjubRegistrarComponent, data: { title: "Registrar Inscripciones" } } 
 /*  { path: 'cargaMasiva', component: CargaMasivaComponent},
  { path: 'registro', component: RegistroComponent},
  { path: 'socioemocional', component: SocioEmocionalComponent},
  { path: 'pedagogico', component: PedagogicoComponent}, */
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PrivateRoutingModule { }
