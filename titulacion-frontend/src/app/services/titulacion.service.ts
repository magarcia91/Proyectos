import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { HttpClient,HttpHeaders} from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Ponderacion } from '../core/model/ponderacion';
import { FechasTitulacion } from '../core/model/fechas-titulacion';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TitulacionService {

  urlTit:string=environment.baseUrlTit;
  header = {
    headers: new HttpHeaders().set(
      'Authorization',
      'eyJhbGciOiJIUzI1NiJ9.eyJjb2RpZ28iOjEwNjkwMTMsImlkZW50aWZpY2FjaW9uIjoiamF2aWVyLmd1YW5vbHVpc2EiLCJleHAiOjE2Mzk1ODIxMzIsImp0aSI6IjdiYWUzM2NhLTlhZGEtNDY3OC05OTk5LWUxZTJlYTliZmQzZSJ9.-nMqLsSRW2yP-z1oMG1zMAjwLgiZPX28aKZiURPPKrY'
    ),
  };

  urlCat:string=environment.baseUrlCat;
  headerCat = {
    headers: new HttpHeaders().set(
      'Authorization',
      'eyJhbGciOiJIUzI1NiJ9.eyJjb2RpZ28iOjEwNjkwMTMsImlkZW50aWZpY2FjaW9uIjoiamF2aWVyLmd1YW5vbHVpc2EiLCJleHAiOjE2Mzk1ODIxMzIsImp0aSI6IjdiYWUzM2NhLTlhZGEtNDY3OC05OTk5LWUxZTJlYTliZmQzZSJ9.-nMqLsSRW2yP-z1oMG1zMAjwLgiZPX28aKZiURPPKrY'
    ),
  };

  ponderacion:Ponderacion;
  fechasTitulacion:FechasTitulacion;

  constructor(private http :HttpClient) { }

  listAnioRegimen(): Observable<any> {
    let url_ws=`${this.urlCat}/listarAnioRegimen`;
    return this.http.get<any>(url_ws,this.headerCat).pipe(
      catchError((e) => {
         return throwError(e);
      })
    );    
  }

  listTipoEducacion(): Observable<any> {
    let url_ws=`${this.urlCat}/listarTipoEducacion`;
    return this.http.get<any>(url_ws,this.headerCat).pipe(
      catchError((e) => {
         return throwError(e);
      })
    );    
  }

  listPonderacion(): Observable<any> {
    let url_ws=`${this.urlTit}/listarModelo`;
    return this.http.get<any>(url_ws,this.header).pipe(
      catchError((e) => {
         return throwError(e);
      })
    );    
  }

  listFechasTitulacion(): Observable<any> {
    let url_ws=`${this.urlTit}/listar`;
    return this.http.get<any>(url_ws,this.header).pipe(
      catchError((e) => {
         return throwError(e);
      })
    );    
  }  

  updatePonderacion(formulario:Ponderacion): Observable<any> {
    let url_ws=`${this.urlTit}/guardarModeloCalificacion`;
    let jsonEnvio={
    "mcaCodigo":formulario.mcaCodigo,
    "codRegAniLec":formulario.codRegAniLec,
    "codTipoEducacion": formulario.codTipoEducacion,    
    "mcaDenominacion": formulario.mcaDenominacion,
    "mcaPorcentaje": formulario.mcaPorcentaje,
    "mcaHasta":formulario.mcaHasta,
    "mcaDesde":formulario.mcaDesde,
    "mcaEstado":formulario.mcaEstado
    }
     
    return this.http.post(url_ws,jsonEnvio,{
      headers: new HttpHeaders({
        'Content-type':'application/json',
        'Authorization':'eyJhbGciOiJIUzI1NiJ9.eyJjb2RpZ28iOjEwNjkwMTMsImlkZW50aWZpY2FjaW9uIjoiamF2aWVyLmd1YW5vbHVpc2EiLCJleHAiOjE2Mzk1ODIxMzIsImp0aSI6IjdiYWUzM2NhLTlhZGEtNDY3OC05OTk5LWUxZTJlYTliZmQzZSJ9.-nMqLsSRW2yP-z1oMG1zMAjwLgiZPX28aKZiURPPKrY'
      })
    }).pipe(
      catchError((e) => {      
        return throwError(e);
      })
    );
  }

  updateFechasTitulacion(formulario:FechasTitulacion): Observable<Object> {
    let url_ws=`${this.urlTit}/guardarFechaTitulacion`;
    let jsonEnvio={
    "ftiCodigo":formulario.ftiCodigo,
    "codRegAniLec":formulario.codRegAniLec,
    "codTipoEducacion": formulario.codTipoEducacion,    
    "ftiInicioGeneral": formulario.ftiInicioGeneral,
    "ftiFinGeneral": formulario.ftiFinGeneral,
    "ftiInicioExonerado":formulario.ftiInicioExonerado,
    "ftiFinExonerado":formulario.ftiFinExonerado,
    "ftiEstado":formulario.ftiEstado
    }
     
    return this.http.post(url_ws,jsonEnvio,{
      headers: new HttpHeaders({
        'Content-type':'application/json',
        'Authorization':'eyJhbGciOiJIUzI1NiJ9.eyJjb2RpZ28iOjEwNjkwMTMsImlkZW50aWZpY2FjaW9uIjoiamF2aWVyLmd1YW5vbHVpc2EiLCJleHAiOjE2Mzk1ODIxMzIsImp0aSI6IjdiYWUzM2NhLTlhZGEtNDY3OC05OTk5LWUxZTJlYTliZmQzZSJ9.-nMqLsSRW2yP-z1oMG1zMAjwLgiZPX28aKZiURPPKrY'
      })
    }).pipe(
      catchError((e) => {      
        return throwError(e);
      })
    );    
  }

  savePonderacion(formulario:Ponderacion){
    let url_ws=`${this.urlTit}/guardarModeloCalificacion`;
    let jsonEnvio={
    "mcaCodigo":formulario.mcaCodigo===0?null:formulario.mcaCodigo,
    "codRegAniLec":formulario.codRegAniLec,
    "codTipoEducacion": formulario.codTipoEducacion,    
    "mcaDenominacion": formulario.mcaDenominacion,
    "mcaPorcentaje": formulario.mcaPorcentaje,
    "mcaHasta":formulario.mcaHasta,
    "mcaDesde":formulario.mcaDesde,
    "mcaEstado":formulario.mcaEstado
    }
     
    return this.http.post(url_ws,jsonEnvio,{
      headers: new HttpHeaders({
        'Content-type':'application/json',
        'Authorization':'eyJhbGciOiJIUzI1NiJ9.eyJjb2RpZ28iOjEwNjkwMTMsImlkZW50aWZpY2FjaW9uIjoiamF2aWVyLmd1YW5vbHVpc2EiLCJleHAiOjE2Mzk1ODIxMzIsImp0aSI6IjdiYWUzM2NhLTlhZGEtNDY3OC05OTk5LWUxZTJlYTliZmQzZSJ9.-nMqLsSRW2yP-z1oMG1zMAjwLgiZPX28aKZiURPPKrY'
      })
    }).pipe(
      catchError((e) => {      
        return throwError(e);
      })
    );
  } 

  saveFechas(formulario:FechasTitulacion){
    let url_ws=`${this.urlTit}/guardarFechaTitulacion`;
    let jsonEnvio={
    "ftiCodigo":formulario.ftiCodigo,    
    "codRegAniLec":formulario.codRegAniLec,
    "codTipoEducacion":formulario.codTipoEducacion,
    "ftiInicioGeneral": formulario.ftiInicioGeneral,    
    "ftiFinGeneral": formulario.ftiFinGeneral,
    "ftiInicioExonerado": formulario.ftiInicioExonerado,
    "ftiFinExonerado":formulario.ftiFinExonerado,
    "ftiEstado":formulario.ftiEstado,  
    }
     
    return this.http.post(url_ws,jsonEnvio,{
      headers: new HttpHeaders({
        'Content-type':'application/json',
        'Authorization':'eyJhbGciOiJIUzI1NiJ9.eyJjb2RpZ28iOjEwNjkwMTMsImlkZW50aWZpY2FjaW9uIjoiamF2aWVyLmd1YW5vbHVpc2EiLCJleHAiOjE2Mzk1ODIxMzIsImp0aSI6IjdiYWUzM2NhLTlhZGEtNDY3OC05OTk5LWUxZTJlYTliZmQzZSJ9.-nMqLsSRW2yP-z1oMG1zMAjwLgiZPX28aKZiURPPKrY'
      })
    }).pipe(
      catchError((e) => {      
        return throwError(e);
      })
    );
  }

  filtroPonderacion(codRegAniLec:any,codTipoEducacion:any): Observable<any>{
    let url_ws=`${this.urlTit}/listaRegTipo/${codRegAniLec}/${codTipoEducacion}`;
    return this.http.get(url_ws,this.header).pipe(
      catchError((e) => {
         return throwError(e);
      })
    ); 
  }


}    

/* saveDataPonderacion(ponderacion: Object): Observable<Object> {
    let url_ws=`${this.urlTit}/guardarModeloCalificacion`;
    return this.http.post(url_ws,this.header,ponderacion).pipe(
      catchError((e) => {
        console.log(e)
         return throwError(e);
      })
    );    
  }

  saveDataFechasTitulacion(fechasTitulacion: Object): Observable<Object> {
    let url_ws=`${this.urlTit}/guardarFechaTitulacion`;
    return this.http.post(url_ws,this.header, fechasTitulacion).pipe(
      catchError((e) => {
        return throwError(e);
      })
    );    
  } */

/* updatePonderacion(): Observable<Object> {
  let url_ws=`${this.url}/guardarModeloCalificacion`;
  return this.http.post(url_ws,this.header).pipe(
    catchError((e) => {
       return throwError(e);
    })
  );    
} */

//return this.http.get<any>(`${environment.baseUrl}/listarAnioRegimen`); 
//return this.http.get<any>(`${environment.baseUrl}/listarTipoEducacion`);   
//return this.http.get(`${environment.baseUrl1}`+'/listarModelo');  
//return this.http.get(`${environment.baseUrl1}`+'/listar');
//return this.http.put(`${environment.baseUrl1}/buscarCodigoModelo/${mcaCodigo}`, value);     
//return this.http.put(`${environment.baseUrl1}/buscarCodigoModelo/${ftiCodigo}`, value);    
//return this.http.post(`${environment.baseUrl1}`+'/guardarModeloCalificacion', ponderacion);  
//return this.http.post(`${environment.baseUrl1}`+'/guardarModeloCalificacion', fechasTitulacion); 