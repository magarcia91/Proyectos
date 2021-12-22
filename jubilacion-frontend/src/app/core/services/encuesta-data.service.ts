import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/core/services/authService';
import { environment } from 'src/environments/environment';
import { Encuesta } from '../models/interfaces/encuesta.model';
import { Pregunta } from '../models/interfaces/pregunta.model';
import { Respuesta } from '../../core/models/interfaces/respuesta.model';
import { catchError } from 'rxjs/operators';
import { throwError, Observable } from 'rxjs';
import { Texto } from '../../core/models/interfaces/texto.model';
import { EstudianteEncuesta } from '../../core/models/interfaces/estudianteEncuesta.model';

@Injectable({
  providedIn: 'root'
})
export class EncuestaDataService {

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
  consultarEncuestaPorCedula(cedula:string){
    let url_ws=`${this.url}/private/buscarEncuestadoPorCedula/${cedula}`;
    return this.http.get(url_ws,this.header).pipe(
      catchError((e) => {
        this.isNoAutorizado(e);
        return throwError(e);
      })
    );
  }
  consultarEncuestaPorCodigo(codigo:number){
    let url_ws=`${this.url}/private/buscarEncuestadoPorCodigo/${codigo}`;
    return this.http.get(url_ws,this.header).pipe(
      catchError((e) => {
        this.isNoAutorizado(e);
        return throwError(e);
      })
    );
  }

  consultarEncuestaPorIdentidad(identidad:string){
    let url_ws=`${this.url}/private/buscarEstudiantePorIdentidad/${identidad}`;
    return this.http.get(url_ws,this.header).pipe(
      catchError((e) => {
        this.isNoAutorizado(e);
        return throwError(e);
      })
    );
  }
  consultarPreguntaPorTipoGrado(tipo: number, grado:number){
    let url_ws=`${this.url}/private/listarPreguntaPortpeCodigo/${tipo}/${grado}`;
    return this.http.get<Pregunta[]>(url_ws,this.header).pipe(
      catchError((e) => {
        this.isNoAutorizado(e);
        return throwError(e);
      })
    );
  }
  consultarEncuestaPorEstudiante(tipo: number, estudiante:number){
    let url_ws=`${this.url}/private/listarEstudiantePreguntaEncuesta/${tipo}/${estudiante}`;
    return this.http.get<EstudianteEncuesta[]>(url_ws,this.header).pipe(
      catchError((e) => {
        this.isNoAutorizado(e);
        return throwError(e);
      })
    );
  }
  consultarTextoPorGrado(grado:number){
    let url_ws=`${this.url}/private/buscarTextoPorGrado/${grado}`;
    return this.http.get<Texto[]>(url_ws,this.header).pipe(
      catchError((e) => {
        this.isNoAutorizado(e);
        return throwError(e);
      })
    );
  }
  consultarRespuestasPregunta(pregunta:number){
    let url_ws=`${this.url}/private/listarPregunta/${pregunta}`;
    return this.http.get<Respuesta[]>(url_ws,this.header).pipe(
      catchError((e) => {
        this.isNoAutorizado(e);
        return throwError(e);
      })
    );
  }
  guardarEncuesta(formulario:Encuesta){
    let url_ws=`${this.url}/private/guardarEncuesta`;
    let jsonEnvio={
      "encEstado":formulario.encEstado,
      "preCodigo":formulario.preCodigo,
      "resCodigo":formulario.resCodigo,
      "usuCodigo":localStorage.getItem('codUsuario'),
      "estCodigo":formulario.estCodigo
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
