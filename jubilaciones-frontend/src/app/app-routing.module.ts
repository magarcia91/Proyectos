import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ParjubEditarComponent } from './pages/editar/parjub-editar/parjub-editar.component';
import { ParjubEliminarComponent } from './pages/eliminar/parjub-eliminar/parjub-eliminar.component';
import { ParjubListarComponent } from './pages/listar/parjub-listar/parjub-listar.component';
import { ParjubRegistrarComponent } from './pages/registrar/parjub-registrar/parjub-registrar.component';

const routes: Routes = [
  { path: "", redirectTo: "/", pathMatch: "full" },
  { path: 'jubilaciones/listar', component: ParjubListarComponent, data: { title: "Detalle Inscripciones" } },
  { path: 'jubilaciones/modificar/:parcod', component: ParjubEditarComponent, data: { title: "Actualizar Inscripciones" } },
  { path: 'jubilaciones/registrar', component: ParjubRegistrarComponent, data: { title: "Registrar Inscripciones" } },
  { path: 'jubilaciones/eliminar/:parcod', component: ParjubEliminarComponent, data: { title: "Eliminar Inscripciones" } } 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
