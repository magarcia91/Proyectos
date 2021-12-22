import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Parjub } from 'src/app/model/parjub';
import { Partipojubilacion } from 'src/app/model/partipojubilacion';
import { environment } from 'src/environments/environment';
import { catchError } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
  })

export class ParjubService {
     
  constructor(private http :HttpClient) { }

  list(): Observable<any> {  
    return this.http.get(`${environment.baseUrl}`+'/listar');  
  } 

  listTipoDiscapacidadPorTipoJubilacion(tipjubEstado: any){
    return this.http.get(`${environment.baseUrl}/listarTipoDiscapacidadporTipoJubilacion/${tipjubEstado}`);  
  }

  listTipoJubilacion():Observable<Partipojubilacion[]> {
    return this.http.get<Partipojubilacion[]>(`${environment.baseUrl}/listarTipoJubilacion`);
  }

  listTipoDiscapacidad():Observable<Partipojubilacion[]> {
    return this.http.get<Partipojubilacion[]>(`${environment.baseUrl}/listarTipoDiscapacidad`);
  }
  
  
  updateItem (parJubCod: number, value: any): Observable<Object> {  
    return this.http.put(`${environment.baseUrl}/modificar/${parJubCod}`, value);  
  } 

  createItem (parJub: Object): Observable<object> {  
    return this.http.post(`${environment.baseUrl}`+'/registrar', parJub);  
  }  

  saveJubilaciones(formulario:Parjub){

    let jsonEnvio={

      "parcod":formulario.parcod,
      "partipojubilacion":formulario.partipojubilacion,
      "partipodiscapacidad":formulario.partipodiscapacidad,
      "paredad": formulario.paredad,    
      "partiemposervicio": formulario.partiemposervicio,
      "parminaportaciones": formulario.parminaportaciones,
      "parestado":formulario.parestado  
      }
      return this.http.post(`${environment.baseUrl}`+'/registrar', jsonEnvio);      
  }

  updateJubilaciones(formulario:Parjub): Observable<any> {      

      let jsonEnvio={

      "parcod":formulario.parcod,
      "partipojubilacion":formulario.partipojubilacion,
      "partipodiscapacidad": formulario.partipodiscapacidad,    
      "paredad": formulario.paredad,
      "partiemposervicio": formulario.partiemposervicio,
      "parminaportaciones":formulario.parminaportaciones,
      "parestado":formulario.parestado   
      }
       
      return this.http.post(`${environment.baseUrl}`+'/registrar', jsonEnvio);
    } 

  deleteItem (parJubCod: number): Observable<any> {  
      return this.http.delete(`${environment.baseUrl}/eliminar/${parJubCod}`, { responseType: 'text' });  
  }
  
  getItem(parJubCod: number): Observable<any> {
    return this.http.get(`${environment.baseUrl}/listar/${parJubCod}`);
  }

  
}
