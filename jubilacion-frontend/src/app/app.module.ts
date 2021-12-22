import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SharedModule } from './shared/shared.module';
import { CoreModule } from './core/core.module';
import { LayoutComponent } from './layout/layout.component';
import { LoginComponent } from './login/login.component';
import { LoaderInterceptor } from './interceptors/loader.interceptor';
import { AuthService } from './core/services/authService';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PrivateModule } from './private/private.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgxSpinnerModule } from 'ngx-spinner';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { DataTablesModule } from 'angular-datatables';
import { MatListModule } from '@angular/material/list';


@NgModule({
  declarations: [AppComponent, LayoutComponent, LoginComponent],
  imports: [
    HttpClientModule,
    AppRoutingModule,
    BrowserModule,
    SharedModule,
    CoreModule,
    FormsModule,   
    ReactiveFormsModule,
    PrivateModule,
    BrowserAnimationsModule,
    NgxSpinnerModule,
    Ng2SearchPipeModule,
    DataTablesModule,
    MatListModule    
 ],
  exports: [
  ],
  providers: [
    AuthService,
    { provide: HTTP_INTERCEPTORS, useClass: LoaderInterceptor, multi: true },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
