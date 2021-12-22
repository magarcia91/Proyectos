import { Routes } from '@angular/router';
import { LoginComponent } from 'app/login/login.component';
import { DashboardComponent } from '../../dashboard/dashboard.component';
import { DatosDocenteComponent } from 'app/pages/datos-docente/datos-docente.component';
import { ClaveComponent } from 'app/pages/clave/clave.component';
import { RecuperarClaveComponent } from 'app/pages/recuperar-clave/recuperar-clave.component';
import { RecuperarCorreoComponent } from 'app/pages/recuperar-correo/recuperar-correo.component';
import { EncuestaComponent } from 'app/pages/encuesta/encuesta.component';


export const AdminLayoutRoutes: Routes = [
    { path: 'dashboard', component: DashboardComponent },
    { path: 'login', component: LoginComponent },
    { path: 'datosDocente', component: DatosDocenteComponent },
    { path: 'clave', component: ClaveComponent },
    { path: 'recuperarClave', component: RecuperarClaveComponent },
    { path: 'recuperarCorreo', component: RecuperarCorreoComponent },
    { path: 'encuesta', component: EncuestaComponent }
];
