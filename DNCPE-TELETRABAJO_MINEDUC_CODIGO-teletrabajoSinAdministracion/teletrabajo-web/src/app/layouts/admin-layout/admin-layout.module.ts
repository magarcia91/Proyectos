import { CommonModule, NgSwitch, NgSwitchCase } from '@angular/common';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule, MatCheckboxModule, MatFormFieldModule, MatInputModule, MatNativeDateModule, MatRippleModule, MatSelectModule, MatTooltipModule, MatAutocompleteModule, MatRadioModule } from '@angular/material';
import { RouterModule } from '@angular/router';
import { LoginComponent } from 'app/login/login.component';
import { DatosDocenteComponent } from 'app/pages/datos-docente/datos-docente.component';
import { DashboardComponent } from '../../dashboard/dashboard.component';
import { AdminLayoutRoutes } from './admin-layout.routing';
import { ClaveComponent } from 'app/pages/clave/clave.component';
import { RecuperarClaveComponent } from 'app/pages/recuperar-clave/recuperar-clave.component';
import { RecuperarCorreoComponent } from 'app/pages/recuperar-correo/recuperar-correo.component';
import { EncuestaComponent } from 'app/pages/encuesta/encuesta.component';


@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(AdminLayoutRoutes),
    FormsModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatRippleModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatTooltipModule,
    MatNativeDateModule,
    MatCheckboxModule,
    MatAutocompleteModule,
    MatRadioModule
  ],
  declarations: [
    DashboardComponent,
    LoginComponent,
    DatosDocenteComponent,
    ClaveComponent,
    RecuperarClaveComponent,
    RecuperarCorreoComponent,
    EncuestaComponent,
  ],
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA,
    NO_ERRORS_SCHEMA
  ],
  entryComponents: [],
  providers: [
  ]
})

export class AdminLayoutModule { }
