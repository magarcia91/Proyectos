import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Parjub } from '../models/parjub';
import { environment } from 'src/environments/environment';

@Injectable({
    providedIn: 'root'
  })

export class ParjubService {
     
  constructor(private http :HttpClient) { }

  list(): Observable<Parjub[]> {
     return this.http.get<Parjub[]>(`${environment.baseUrl}/listar`);
   }

  list1(): Observable<any> {  
    return this.http.get(`${environment.baseUrl}`+'/listar');  
  }  
   
  updateItem (parJubCod: number, value: any): Observable<Object> {  
    return this.http.put(`${environment.baseUrl}/modificar/${parJubCod}`, value);  
  } 

  createItem (parJub: Object): Observable<object> {  
    return this.http.post(`${environment.baseUrl}`+'/registrar', parJub);  
  }  

  deleteItem (parJubCod: number): Observable<any> {  
      return this.http.delete(`${environment.baseUrl}/eliminar/${parJubCod}`, { responseType: 'text' });  
  }
  
  getItem(parJubCod: number): Observable<any> {
    return this.http.get(`${environment.baseUrl}/listar/${parJubCod}`);
  }

  
}
