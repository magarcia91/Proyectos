import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContactoEmailComponent } from './components/contacto-email/contacto-email.component';
import { ListarContactoComponent } from './components/listar-contacto/listar-contacto.component';

const routes: Routes = [

  { path: "", redirectTo: "/", pathMatch: "full" },
  { path: 'emails', component: ListarContactoComponent, data: { title: "Listado contactos" } }, 
  { path: 'emails/sendEmail', component: ContactoEmailComponent, data: { title: "Envio email" } }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
