import { AgmCoreModule } from '@agm/core';
import { DatePipe, HashLocationStrategy, LocationStrategy } from '@angular/common';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { MatCheckboxModule, MatDialogModule, MatInputModule, MatNativeDateModule, MatProgressSpinnerModule, MatSelectModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app.routing';
import { ComponentsModule } from './components/components.module';
import { ActividadDialogComponent } from './dashboard/actividad-dialog/actividad-dialog.component';
import { LoaderInterceptor } from './interceptors/loader.interceptor';
import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
import { LoaderComponent } from './loader/loader.component';
import { ListaEncuestasDialogComponent } from './pages/encuesta/dialog/lista-encuestas-dialog.component';
import { AgendaService } from './services/agenda.service';
import { AuthService } from './services/AuthService';
import { ExcelService } from './services/excel.service';
import { LoaderService } from './services/Loader.service';

@NgModule({
  imports: [
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    HttpClientModule,
    MatProgressSpinnerModule,
    ComponentsModule,
    RouterModule,
    MatDialogModule,
    MatSelectModule,
    MatInputModule,
    AppRoutingModule,
    MatNativeDateModule,
    MatCheckboxModule,
    AgmCoreModule.forRoot({
      apiKey: 'YOUR_GOOGLE_MAPS_API_KEY'
    })
  ],
  declarations: [
    AppComponent,
    AdminLayoutComponent,
    LoaderComponent,
    ActividadDialogComponent,
    ListaEncuestasDialogComponent  
  ],
  providers: [AuthService, LoaderService,
    ExcelService, DatePipe, AgendaService,
    { provide: HTTP_INTERCEPTORS, useClass: LoaderInterceptor, multi: true },
    { provide: LocationStrategy, useClass: HashLocationStrategy }],
  bootstrap: [AppComponent],
  entryComponents: [ActividadDialogComponent, ListaEncuestasDialogComponent],
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA,
    NO_ERRORS_SCHEMA
  ]
})
export class AppModule { }
