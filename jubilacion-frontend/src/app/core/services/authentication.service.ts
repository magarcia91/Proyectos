import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AudSesion } from './../models/aud-sesion';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { environment } from './../../../environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthService } from 'src/app/core/services/authService';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {
  header = {
    headers: new HttpHeaders().set(
      'Authorization',
      localStorage.getItem('token')
    ),
  };
  public tablaSesion: AudSesion;

  constructor(private httpClient: HttpClient,
              private authService: AuthService) {}
  getAuthData(): any[] {
    if (this.authService.isAuthenticated()) {
      const datosSesion: Array<any> = [];
      datosSesion.push(localStorage.getItem('identificacion'));
      datosSesion.push(JSON.parse(localStorage.getItem('fechaInicio')));
      datosSesion.push(localStorage.getItem('nombre').substring(0, 3));
      datosSesion.push(JSON.parse(localStorage.getItem('fechaFinal')));
      return datosSesion;
    }
  }
  /*guardarDatosSesion(audSesion: AudSesion): Observable<AudSesion> {
    return this.httpClient
      .post<AudSesion>(
        `${environment.url_back_end}/audSesion/save`,
        audSesion,
        this.header
      )
      .pipe(
        catchError((e) => {
          return throwError(e);
        })
      );
  }*/

}
