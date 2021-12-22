import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Grado } from '../models/interfaces/grado.model';
import { Nacionalidad } from '../models/interfaces/nacionalidad.model';
import { Registro } from '../models/interfaces/registro.model';
import { Sede } from '../models/interfaces/sede.model';
import { catchError } from 'rxjs/operators';
import { throwError, Observable } from 'rxjs';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/core/services/authService';
import { Etnia } from '../models/interfaces/etnia.model';
@Injectable({
  providedIn: 'root'
})
export class RegistroDataService {
  url:string=environment.url_back_end;
  header = {
    headers: new HttpHeaders().set(
      'Authorization',
      localStorage.getItem('token')
    ),
  };
  constructor(
    public http:HttpClient,
    private authService: AuthService,
    private router: Router
    
  ) { }
  private isNoAutorizado(e): boolean {
    if (e.status === 401) {
      if (this.authService.isAuthenticated()) {
        this.authService.logout();
      }
      this.router.navigate(['/login']);
      return true;
    }
    if (e.status === 403) {
      this.authService.logout();
      this.router.navigate(['/login']);
      return true;
    }
    return false;
  }
  consultarCedula(cedula:string){
     let url_ws=`${this.url}/private/buscarPorCedula/${cedula}`;
     return this.http.get(url_ws,this.header).pipe(
      catchError((e) => {
        this.isNoAutorizado(e);
        return throwError(e);
      })
    );
  }
  consultarNacionalidades(){
    let url_ws=`${this.url}/private/nacionalidad`;
    return this.http.get<Nacionalidad[]>(url_ws,this.header).pipe(
      catchError((e) => {
        this.isNoAutorizado(e);
        return throwError(e);
      })
    );
  }
  consultarSedes(){
    let url_ws=`${this.url}/private/sede`;
    return this.http.get<Sede[]>(url_ws,this.header).pipe(
      catchError((e) => {
        this.isNoAutorizado(e);
        return throwError(e);
      })
    );
  }
  consultarGrados(){
    let url_ws=`${this.url}/private/listarGradosPorNiveles`;
    return this.http.get<Grado[]>(url_ws,this.header).pipe(
      catchError((e) => {
        this.isNoAutorizado(e);
        return throwError(e);
      })
    );
  }
  consultarEtnias(){
    let url_ws=`${this.url}/private/etnias`;
    return this.http.get<Etnia[]>(url_ws,this.header).pipe(
      catchError((e) => {
        this.isNoAutorizado(e);
        return throwError(e);
      })
    );
  }
  guardarRegistro(formulario:Registro){
    let url_ws=`${this.url}/private/guardarEstudiante`;
    let jsonEnvio={
      "estCedula":formulario.documentoIdentidad,
      "estComidas":formulario.comidasAlDia,
      "estDiscapacidad":formulario.discapacidad,
      "estFechaNacimiento":formulario.fechaNacimiento,
      "estMatriculado":formulario.esMatriculado,
      "estMovil":formulario.celular,
      "estNombre":formulario.nombre,
      "estPeso":formulario.peso,
      "estTalla":formulario.talla,
      "estVisitasMedicas":formulario.visitaMedico,
      "graCodigo":formulario.grado,
      "paiCodigo":formulario.nacionalidad,
      "usuCodigo":localStorage.getItem('codUsuario'),
      "codigoSede":formulario.sede,
      "estGenero":formulario.genero,
      "estMovilidadHumana": formulario.movilidadHumana,
      "nacPais": formulario.etnia,
      "estDireccion": formulario.direccion,
      "estConectividad": formulario.conectividad,
      "estCambioVivenda": formulario.cambio_vivienda,
      "estIeCerca": formulario.IE_cerca
    }
    
    return this.http.post(url_ws,jsonEnvio,{
      headers: new HttpHeaders({
        'Content-type':'application/json',
        'Authorization':localStorage.getItem('token')
      })
    }).pipe(
      catchError((e) => {
        this.isNoAutorizado(e);
        return throwError(e);
      })
    );
  }
  guardarRegistroExcel(formulario:Registro){
    let url_ws=`${this.url}/private/guardarEstudianteExcel`;
    let jsonEnvio={
      "estCedula":formulario.documentoIdentidad,
      "estComidas":formulario.comidasAlDia,
      "estDiscapacidad":formulario.discapacidad,
      "estFechaNacimiento":formulario.fechaNacimiento,
      "estMatriculado":formulario.esMatriculado,
      "estMovil":formulario.celular,
      "estNombre":formulario.nombre,
      "estPeso":formulario.peso,
      "estTalla":formulario.talla,
      "estVisitasMedicas":formulario.visitaMedico,
      "graCodigo":formulario.grado,
      "paiCodigo":formulario.nacionalidad,
      "usuCodigo":localStorage.getItem('codUsuario'),
      "codigoSede":formulario.sede,
      "estGenero":formulario.genero,
      "estMovilidadHumana": formulario.movilidadHumana,
      "nacPais": formulario.etnia,
      "estDireccion": formulario.direccion,
      "estConectividad": formulario.conectividad,
      "estCambioVivenda": formulario.cambio_vivienda,
      "estIeCerca": formulario.IE_cerca,
      "estIdentidad":formulario.estIdentidad
    }
    
    return this.http.post(url_ws,jsonEnvio,{
      headers: new HttpHeaders({
        'Content-type':'application/json',
        'Authorization':localStorage.getItem('token')
      })
    }).pipe(
      catchError((e) => {
        this.isNoAutorizado(e);
        return throwError(e);
      })
    );
  }
}
