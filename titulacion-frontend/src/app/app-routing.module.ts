import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConsejoTitulacionComponent } from './pages/consejo-ejecutivo/consejo-ejecutivo.component';
import { FechasTitulacionComponent } from './pages/fechas-titulacion/fechas-titulacion.component';
import { ListarPonderacionTitulacionComponent } from './pages/listar-ponderacion-titulacion/listar-ponderacion-titulacion.component';
import { PonderacionTitulacionComponent } from './pages/ponderacion-titulacion/ponderacion-titulacion.component';
import { EditarFechasComponent } from './pages/editar-fechas/editar-fechas/editar-fechas.component';
import { ListarFechasTitulacionComponent } from './pages/listar-fechas-titulacion/listar-fechas-titulacion.component';


const routes: Routes = [
  { path: "", redirectTo: "/", pathMatch: "full" },  
  { path: 'guardarModeloCalificacion', component: PonderacionTitulacionComponent, data: { title: "Registrar Ponderación" } },
  { path: 'listarModelo', component: ListarPonderacionTitulacionComponent, data: { title: "Detalle Ponderación" } },
  { path: 'guardarModeloCalificacion', component: EditarFechasComponent, data: { title: "Actualizar Ponderación" } },
  { path: 'guardarFechaTitulacion', component: FechasTitulacionComponent, data: { title: "Registrar Fechas Titulación" } },
  { path: 'listar', component: ListarFechasTitulacionComponent, data: { title: "Detalle Fecha Titulación" } },
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
